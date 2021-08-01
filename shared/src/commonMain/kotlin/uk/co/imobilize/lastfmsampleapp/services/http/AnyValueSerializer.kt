package uk.co.imobilize.lastfmsampleapp.services.http

import kotlinx.serialization.Contextual
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.json.*

@Serializable
data class AnyValueSurrogate(
    val type : String,
    @Contextual
    val value : Any?
)

class AnyValueDeSerializer : DeserializationStrategy<Any?> {
    override val descriptor : SerialDescriptor = AnyValueSurrogate.serializer().descriptor

    override fun deserialize(decoder: Decoder): Any? {

        if (decoder is JsonDecoder) {

            val element = decoder.decodeJsonElement()

            return getValue(element)
        }

        return null
    }

    fun getValue(element: JsonElement): Any? {

        if (element is JsonNull)
            return null

        if (element is JsonPrimitive) {
            if (element.isString)
                return element.content

            return try {
                element.boolean
            } catch (e: Throwable) {
                try {
                    element.long
                } catch (e: Throwable) {
                    element.double
                }
            }
        } else if (element is JsonObject) {

            val mapElement = element as? JsonObject

            return mapElement?.map { (key, value) ->

                key to getValue(value)

            }?.toMap()

        } else if (element is JsonArray) {

            return element.map {
                getValue(it)
            }
        }

        throw SerializationException("Invalid Json element $element")
    }
}