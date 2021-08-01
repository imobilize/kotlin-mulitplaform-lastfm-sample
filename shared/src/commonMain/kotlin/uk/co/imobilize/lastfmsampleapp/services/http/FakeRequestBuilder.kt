package uk.co.imobilize.lastfmsampleapp.services.http

class FakeRequestBuilder: JSONRequestBuilder {

    private var urlToRequest = ""

    override fun headers(block: HeadersBuilder.() -> Unit): JSONRequestBuilder {
        return this
    }

    override fun usingURL(url: String): JSONRequestBuilder {
        urlToRequest = url
        return this
    }

    override fun with(body: Any): JSONRequestBuilder {
        return this
    }

    override fun post(): JSONRequestBuilder {
        return this
    }

    override fun get(): JSONRequestBuilder {
        return this
    }

    override suspend fun excecute(): Result<JsonResponse> {
        if (urlToRequest.contains("artist.search")) {
            return Result.success(JsonResponse(HttpStatusCode.OK, artistSearchResponse))
        } else {
            return Result.success(JsonResponse(HttpStatusCode.OK, artistDetailResponse))
        }
    }
}

val artistDetailResponse = """
    {
    	"artist": {
    		"bio": {
    			"links": {
    				"link": {
    					"rel": "original",
    					"href": "https:\/\/www.last.fm\/music\/Cher\/+wiki"
    				}
    			},
    			"content": "Cher (born Cherilyn Sarkisian; May 20, 1946) is an Oscar- and Grammy-winning American singer and actress. A major figure for over five decades in the world of popular culture, she is often referred to as the Goddess of Pop for having first brought the sense of female autonomy and self-actualization into the entertainment industry. \n\nShe is known for her distinctive contralto and for having worked extensively across media, as well as for continuously reinventing both her music and image, the latter of which has been known to induce controversy.\n\nCher was born Cherilyn Sarkisian in El Centro, California, on May 20, 1946. She is of Armenian-American, Irish, English, German, and Cherokee ancestry. Cher first caught the eye and ear of the public in 1965 as one-half of the pop rock duo Sonny & Cher, which popularized a peculiar smooth sound that competed successfully with the predominant British Invasion and Motown Sound of the era. After a period in which the duo became obsolete, she re-emerged in the 1970's as a television personality with her shows The Sonny & Cher Comedy Hour and Cher, which attained great popularity.\n\nAt the same time, she established herself as a solo artist with hits such as \"Bang Bang (My Baby Shot Me Down)\", \"Gypsys, Tramps & Thieves\", \"Half-Breed\", and \"Dark Lady\", which dealt with taboo subjects in mainstream popular music. Throughout, she cemented her status as a fashion trendsetter with her daring outfits, and was noted as being the first woman to expose her navel on television. Cher's impact at that time, as described by Phill Marder from Goldmine magazine, \"led the way to advance feminine rebellion in the rock world,\" as she was \"the prototype of the female rock star, setting the standard for appearance and  attitude\"\n\nIn 1983 Cher made a critically acclaimed appearance on Broadway and starred in the film Silkwood, which earned her a nomination for the Academy Award for Best Supporting Actress. In the following years, she became an acclaimed film actress by starring in a string of hit films, including Mask, The Witches of Eastwick, and Moonstruck, for which she won the Academy Award for Best Actress in 1988. At the same time, she established herself as a \"serious rock and roller\" by releasing a series of rock albums and hit singles such as \"I Found Someone\", \"If I Could Turn Back Time\", and \"The Shoop Shoop Song (It's in His Kiss)\".\n\nShe made her directing debut with the film If These Walls Could Talk in 1996 and released the biggest-selling single of her career thus far, \"Believe\", which revolutionized the recording industry because of its pioneer use of Auto-Tune (also known as the \"Cher effect\"). Throughout the 2000's she embarked on a series of concert tours that were among the highest-grossing of all-time.\n\nCher has won an Academy Award, a Grammy Award, an Emmy Award, three Golden Globe Awards, and the Best Actress Award at the Cannes Film Festival for her work in film, music and television. She is the only person  to receive all of these awards. She is also the only artist to have notched a number-one single on a Billboard chart in each of the past six decades. Recognized as one of the best-selling music artists of all time, she has sold more than 100 million solo albums worldwide and 40 million records as part of Sonny & Cher.\n\nOfficial website: http:\/\/www.cher.com\/ <a href=\"https:\/\/www.last.fm\/music\/Cher\">Read more on Last.fm<\/a>. User-contributed text is available under the Creative Commons By-SA License; additional terms may apply.",
    			"published": "10 Oct 2018, 12:49",
    			"summary": "Cher (born Cherilyn Sarkisian; May 20, 1946) is an Oscar- and Grammy-winning American singer and actress. A major figure for over five decades in the world of popular culture, she is often referred to as the Goddess of Pop for having first brought the sense of female autonomy and self-actualization into the entertainment industry. She is known for her distinctive contralto and for having worked extensively across media, as well as for continuously reinventing both her music and image, the latter of which has been known to induce controversy. Cher was born Cherilyn Sarkisian in El Centro, California, on May <a href=\"https:\/\/www.last.fm\/music\/Cher\">Read more on Last.fm<\/a>."
    		},
    		"ontour": 0,
    		"stats": {
    			"playcount": 19872042,
    			"listeners": 1291411
    		},
    		"mbid": "bfcc6d75-a6a5-4bc6-8282-47aec8531818",
    		"image": [{
    			"size": "small",
    			"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/34s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    		}, {
    			"size": "medium",
    			"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/64s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    		}, {
    			"size": "large",
    			"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/174s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    		}, {
    			"size": "extralarge",
    			"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    		}, {
    			"size": "mega",
    			"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    		}, {
    			"size": "",
    			"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    		}],
    		"similar": {
    			"artist": [{
    				"url": "https:\/\/www.last.fm\/music\/Madonna",
    				"name": "Madonna",
    				"image": [{
    					"size": "small",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/34s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "medium",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/64s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "large",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/174s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "extralarge",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "mega",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}]
    			}, {
    				"url": "https:\/\/www.last.fm\/music\/Sonny+&+Cher",
    				"name": "Sonny & Cher",
    				"image": [{
    					"size": "small",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/34s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "medium",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/64s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "large",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/174s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "extralarge",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "mega",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}]
    			}, {
    				"url": "https:\/\/www.last.fm\/music\/Kylie+Minogue",
    				"name": "Kylie Minogue",
    				"image": [{
    					"size": "small",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/34s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "medium",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/64s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "large",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/174s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "extralarge",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "mega",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}]
    			}, {
    				"url": "https:\/\/www.last.fm\/music\/C%C3%A9line+Dion",
    				"name": "CÃ©line Dion",
    				"image": [{
    					"size": "small",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/34s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "medium",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/64s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "large",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/174s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "extralarge",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "mega",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}]
    			}, {
    				"url": "https:\/\/www.last.fm\/music\/Tina+Turner",
    				"name": "Tina Turner",
    				"image": [{
    					"size": "small",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/34s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "medium",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/64s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "large",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/174s\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "extralarge",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "mega",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}, {
    					"size": "",
    					"#text": "https:\/\/lastfm.freetls.fastly.net\/i\/u\/300x300\/2a96cbd8b46e442fc41c2b86b821562f.png"
    				}]
    			}]
    		},
    		"url": "https:\/\/www.last.fm\/music\/Cher",
    		"tags": {
    			"tag": [{
    				"name": "pop",
    				"url": "https:\/\/www.last.fm\/tag\/pop"
    			}, {
    				"name": "female vocalists",
    				"url": "https:\/\/www.last.fm\/tag\/female+vocalists"
    			}, {
    				"name": "80s",
    				"url": "https:\/\/www.last.fm\/tag\/80s"
    			}, {
    				"name": "dance",
    				"url": "https:\/\/www.last.fm\/tag\/dance"
    			}, {
    				"name": "rock",
    				"url": "https:\/\/www.last.fm\/tag\/rock"
    			}]
    		},
    		"name": "Cher",
    		"streamable": "0"
    	}
    }
""".trimIndent()

val artistSearchResponse = """
    {
    	"results": {
    		"opensearch:Query": {
    			"#text": "",
    			"role": "request",
    			"searchTerms": "cher",
    			"startPage": "1"
    		},
    		"opensearch:totalResults": "69863",
    		"opensearch:startIndex": "0",
    		"opensearch:itemsPerPage": "30",
    		"artistmatches": {
    			"artist": [{
    				"name": "Cher",
    				"listeners": "1291411",
    				"mbid": "bfcc6d75-a6a5-4bc6-8282-47aec8531818",
    				"url": "https://www.last.fm/music/Cher",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cheryl Cole",
    				"listeners": "631273",
    				"mbid": "2d499150-1c42-4ffb-a90c-1cc635519d33",
    				"url": "https://www.last.fm/music/Cheryl+Cole",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cher Lloyd",
    				"listeners": "614669",
    				"mbid": "48fbfb0b-92ee-45eb-99c2-0bde4c05962e",
    				"url": "https://www.last.fm/music/Cher+Lloyd",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Black Stone Cherry",
    				"listeners": "360143",
    				"mbid": "1801bd47-46ae-49ff-bfcd-6e01b562d880",
    				"url": "https://www.last.fm/music/Black+Stone+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cheryl",
    				"listeners": "176426",
    				"mbid": "85df56ab-e125-4169-8ac8-e6666128d526",
    				"url": "https://www.last.fm/music/Cheryl",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherry Glazerr",
    				"listeners": "180551",
    				"mbid": "64a0c404-58af-4083-8fc6-a6725ef02ecb",
    				"url": "https://www.last.fm/music/Cherry+Glazerr",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Eagle-Eye Cherry",
    				"listeners": "927163",
    				"mbid": "4a5777b3-f55b-437c-8b23-d9ee7791c7fc",
    				"url": "https://www.last.fm/music/Eagle-Eye+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "CHERRY BULLET",
    				"listeners": "65127",
    				"mbid": "",
    				"url": "https://www.last.fm/music/CHERRY+BULLET",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherub",
    				"listeners": "199262",
    				"mbid": "abf42fca-8c2e-4d55-9fc8-6b1fc65a80f1",
    				"url": "https://www.last.fm/music/Cherub",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Neneh Cherry",
    				"listeners": "309587",
    				"mbid": "527c65d1-9fdb-4482-8796-dde2980bd63a",
    				"url": "https://www.last.fm/music/Neneh+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherish",
    				"listeners": "355603",
    				"mbid": "e82500a8-70ce-46ad-a028-b0690420d560",
    				"url": "https://www.last.fm/music/Cherish",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Acid Black Cherry",
    				"listeners": "33045",
    				"mbid": "a3842d12-306c-498a-ae1d-03ee40e3f2ac",
    				"url": "https://www.last.fm/music/Acid+Black+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Wild Cherry",
    				"listeners": "408328",
    				"mbid": "da5ff827-174b-48d1-9a39-9fa290bb2925",
    				"url": "https://www.last.fm/music/Wild+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cheryl Lynn",
    				"listeners": "265391",
    				"mbid": "c2b8f775-455c-44c3-97ca-f377938da19e",
    				"url": "https://www.last.fm/music/Cheryl+Lynn",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherry Poppin' Daddies",
    				"listeners": "148793",
    				"mbid": "e23612fb-6dd6-4d5c-b638-2611bfc8c48a",
    				"url": "https://www.last.fm/music/Cherry+Poppin%27+Daddies",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Blue Cheer",
    				"listeners": "188760",
    				"mbid": "523b52d7-a819-4111-9085-69fc269c9638",
    				"url": "https://www.last.fm/music/Blue+Cheer",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherry Ghost",
    				"listeners": "133594",
    				"mbid": "1e76c9f2-2f79-4521-a418-a3c22eda30fa",
    				"url": "https://www.last.fm/music/Cherry+Ghost",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Sonny & Cher",
    				"listeners": "340298",
    				"mbid": "c43d2302-02db-487b-b62d-8cb3c57f94c6",
    				"url": "https://www.last.fm/music/Sonny+&+Cher",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Nasty Cherry",
    				"listeners": "72279",
    				"mbid": "",
    				"url": "https://www.last.fm/music/Nasty+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "CHERNIKOVSKAYA HATA",
    				"listeners": "32575",
    				"mbid": "",
    				"url": "https://www.last.fm/music/CHERNIKOVSKAYA+HATA",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Don Cherry",
    				"listeners": "109320",
    				"mbid": "d45e4d9d-45c1-45cb-941a-8a5025874e06",
    				"url": "https://www.last.fm/music/Don+Cherry",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherokee",
    				"listeners": "60794",
    				"mbid": "ea71fddc-7e41-470f-8e13-6cd50ae981da",
    				"url": "https://www.last.fm/music/Cherokee",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherri Bomb",
    				"listeners": "29739",
    				"mbid": "41db537e-1150-43b2-9a94-a7b8a08cd23d",
    				"url": "https://www.last.fm/music/Cherri+Bomb",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "cehryl",
    				"listeners": "46753",
    				"mbid": "",
    				"url": "https://www.last.fm/music/cehryl",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherrie",
    				"listeners": "19197",
    				"mbid": "",
    				"url": "https://www.last.fm/music/Cherrie",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherrelle",
    				"listeners": "77703",
    				"mbid": "2a0b3bf9-0d04-4e49-91f5-9530cbebab55",
    				"url": "https://www.last.fm/music/Cherrelle",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cheers Elephant",
    				"listeners": "57316",
    				"mbid": "89724b2e-c0ba-43ae-9fcb-75011deb059f",
    				"url": "https://www.last.fm/music/Cheers+Elephant",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cheriimoya",
    				"listeners": "24021",
    				"mbid": "",
    				"url": "https://www.last.fm/music/Cheriimoya",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Jeanne Cherhal",
    				"listeners": "72752",
    				"mbid": "1c964d5b-ddf8-443f-a722-4e3d57b55d3c",
    				"url": "https://www.last.fm/music/Jeanne+Cherhal",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}, {
    				"name": "Cherubs",
    				"listeners": "18421",
    				"mbid": "6106ec43-8658-4fc3-b8a6-5379831a6cfa",
    				"url": "https://www.last.fm/music/Cherubs",
    				"streamable": "0",
    				"image": [{
    					"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "small"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "medium"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "large"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "extralarge"
    				}, {
    					"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
    					"size": "mega"
    				}]
    			}]
    		},
    		"@attr": {
    			"for": "cher"
    		}
    	}
    }
""".trimIndent()