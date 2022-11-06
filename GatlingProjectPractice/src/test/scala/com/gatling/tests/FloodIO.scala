package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class FloodIO extends Simulation {

	val httpProtocol = http
		.baseUrl("https://challenge.flood.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"sec-ch-ua" -> """Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")

	val headers_1 = Map(
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36",
		"sec-ch-ua" -> """Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_2 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"sec-ch-ua" -> """Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")

	val headers_5 = Map(
		"accept" -> "text/html, application/xhtml+xml",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"sec-ch-ua" -> """Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin",
		"turbolinks-referrer" -> "https://challenge.flood.io/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")

	val headers_6 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
		"origin" -> "https://challenge.flood.io",
		"sec-ch-ua" -> """Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")

    //val uri2 = "https://fonts.googleapis.com/css"

	val scn = scenario("FloodIO")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("https://fonts.googleapis.com/css" + "?family=Open+Sans:400,600&subset=cyrillic")
			.headers(headers_1)))
		.pause(5)
		.exec(http("request_2")
			.get("/")
			.headers(headers_2)
			.resources(http("request_3")
			.get("https://fonts.googleapis.com/css" + "?family=Lobster|Lobster+Two")
			.headers(headers_1)))
		.pause(5)
		.exec(http("request_5")
			.get("/")
			.headers(headers_5))
		.pause(5)
		.exec(http("request_6")
			.post("/start")
			.headers(headers_6)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "CbyMb4Y+z1kWYM/6/7iKm49fJjH+0lR5XLzt/+NBZx8=")
			.formParam("challenger[step_id]", "TnNFLy9aL3lzK21rTi9icGFkNzFpQT09LS1CRVpHZUc5QzRiaGRyL0s1enJnUE9nPT0=--44a41763b15a8e345d604f813679a69944d86587")
			.formParam("challenger[step_number]", "1")
			.formParam("commit", "Start")
			.resources(http("request_7")
			.get("https://fonts.googleapis.com/css" + "?family=Open+Sans:400,600&subset=cyrillic")
			.headers(headers_1)))
		.pause(5)
		.exec(http("request_8")
			.post("/start")
			.headers(headers_6)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "CbyMb4Y+z1kWYM/6/7iKm49fJjH+0lR5XLzt/+NBZx8=")
			.formParam("challenger[step_id]", "T3JpVkJzV3dmZHJYWmJoZnJkeEJFQT09LS0vU0FzME9qTVdQbVVKWm5oeEhWMGFBPT0=--77860374c11799f6cdf53b056209be2fe4af2f07")
			.formParam("challenger[step_number]", "2")
			.formParam("challenger[age]", "26")
			.formParam("commit", "Next")
			.resources(http("request_9")
			.get("https://fonts.googleapis.com/css" + "?family=Open+Sans:400,600&subset=cyrillic")
			.headers(headers_1)))
		.pause(5)
		.exec(http("request_10")
			.post("/start")
			.headers(headers_6)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "CbyMb4Y+z1kWYM/6/7iKm49fJjH+0lR5XLzt/+NBZx8=")
			.formParam("challenger[step_id]", "UDFPL25vMms2QjVaQWlqNmdSNTJ1UT09LS1KMnZYTFE5MGhLbTJ0R1EzUW5WWnp3PT0=--09187f95f35b85e32f96d6ed46a1a23f9f9df639")
			.formParam("challenger[step_number]", "3")
			.formParam("challenger[largest_order]", "")
			.formParam("challenger[order_selected]", "d0lzcWswNkp5RjZuNkF3WGhFRTNqZz09LS1lUjhFTVpXU0VlT1V4VFZFUGoyZkVnPT0=--daf3841f6874b346b34ddb48bbb15055064ac4f5")
			.formParam("commit", "Next")
			.resources(http("request_11")
			.get("https://fonts.googleapis.com/css" + "?family=Open+Sans:400,600&subset=cyrillic")
			.headers(headers_1)))

	setUp(scn.inject(constantUsersPerSec(5) during(60)).protocols(httpProtocol))
}