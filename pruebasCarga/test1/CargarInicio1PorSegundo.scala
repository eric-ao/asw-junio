
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CargarInicio1PorSegundo extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:3000")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_3 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_6 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin")

	val headers_7 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000")

	val headers_8 = Map(
		"Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin")

	val headers_9 = Map("Origin" -> "http://localhost:3000")

	val headers_23 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjE1MywiaWF0IjoxNTkzNzUyNTUzLCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.bSe3kLfDy3q5ByIB_LgTPRayJ2gDXUarwYoI-1-ez7FFAkxRn7jgjBst7smDiUJbh7SUe8lLEhxFzU1AiAoZ8DkSEcR0P2hg30lPc0pLhGv7_SmLltHbSPyKMxD6nkiI3USSdIGRYr6de3re91wpxjNrNr0pLaAOQoWOdbdVEPynCag7b1hh7XIR9__pCbr5YRJSaYbvmUn9PKEp1VMU72bmxuZpeCZA2-pSXFmqo9kd0iUZoTXy6qIIVgzAx7QbjqW3t-TmrdTvY1fuEUfeZIW6g82u_QMWB4idIylvKc69feM5_l5FD3MvdfuA_zO0zb-9LKlzwvTalVT06OP04g")

	val headers_25 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"accept" -> "application/trig,application/ld+json;q=0.9,text/html;q=0.8,application/xhtml+xml;q=0.72,application/n-quads;q=0.7,*/*;q=0.1",
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjE1MywiaWF0IjoxNTkzNzUyNTUzLCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.bSe3kLfDy3q5ByIB_LgTPRayJ2gDXUarwYoI-1-ez7FFAkxRn7jgjBst7smDiUJbh7SUe8lLEhxFzU1AiAoZ8DkSEcR0P2hg30lPc0pLhGv7_SmLltHbSPyKMxD6nkiI3USSdIGRYr6de3re91wpxjNrNr0pLaAOQoWOdbdVEPynCag7b1hh7XIR9__pCbr5YRJSaYbvmUn9PKEp1VMU72bmxuZpeCZA2-pSXFmqo9kd0iUZoTXy6qIIVgzAx7QbjqW3t-TmrdTvY1fuEUfeZIW6g82u_QMWB4idIylvKc69feM5_l5FD3MvdfuA_zO0zb-9LKlzwvTalVT06OP04g")

	val headers_26 = Map(
		"Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "cross-site")

	val headers_27 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjE1NCwiaWF0IjoxNTkzNzUyNTU0LCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.Miv_0zFxet2mFDTeaX146zOfGjAUZujkGDgealzFe4Q0Onip5LwYXtMCtdTAu2Rcs92-5GLjVkFPkdUFf7kAukBKFTeXb-BuhJFKv2ubi4umL7Gm2g128Gk-vzDdKX9a_P82KMNV1fl0LCqa2p1qA19ezHDIYUyGkFe0pTK3MeT4eB_63HA0e6Ur8NnQy7sRGV4LyQQQU_gfRGgtk3pSguJSP1IS96aW9fORRN8jgQboszhRPdeZZPwnbUtseHEbrwm55KAbl9qDPB4OOgjmbjIWMXuYPtvZ--iIxa1y6Km1Xh6aZvjH_-FtlWOann5pJD983uIRvXLSYSvuRWZpXw")

    val uri1 = "http://192.168.8.101:3000/sockjs-node/info"
    val uri3 = "https://ericcc.solid.community"
    val uri4 = "https://fonts.gstatic.com/s"
    val uri5 = "https://fonts.googleapis.com"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/asw-junio/welcome")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri5 + "/css2?family=Amatic+SC&display=swap"),
            http("request_2")
			.get(uri5 + "/css?family=Raleway:400,400i,700,700i|Roboto:300,300i,400,400i,700,700i"),
            http("request_3")
			.get("/asw-junio/locales/en-US/translation.json")
			.headers(headers_3),
            http("request_4")
			.get("/asw-junio/locales/en/translation.json")
			.headers(headers_3),
            http("request_5")
			.get("/asw-junio/locales/es/translation.json")
			.headers(headers_3),
            http("request_6")
			.get("/sockjs-node/info?t=1593752553117")
			.headers(headers_6),
            http("request_7")
			.get(uri1 + "?t=1593752553117")
			.headers(headers_7),
            http("request_8")
			.get("/img/mountain2.jpg")
			.headers(headers_8),
            http("request_9")
			.get(uri4 + "/raleway/v16/1Ptrg8zYS_SKggPNwJYtWqZPAA.woff2")
			.headers(headers_9),
            http("request_10")
			.get(uri4 + "/roboto/v20/KFOlCnqEu92Fr1MmSU5fBBc4.woff2")
			.headers(headers_9),
            http("request_11")
			.get(uri4 + "/raleway/v16/1Ptug8zYS_SKggPNyC0ITw.woff2")
			.headers(headers_9),
            http("request_12")
			.get(uri4 + "/roboto/v20/KFOmCnqEu92Fr1Mu4mxK.woff2")
			.headers(headers_9),
            http("request_13")
			.get("/asw-junio/img/logoNav.jpg")
			.headers(headers_8),
            http("request_14")
			.get("/asw-junio/img/icon/apps.svg")
			.headers(headers_8),
            http("request_15")
			.get("/asw-junio/img/people.svg")
			.headers(headers_8),
            http("request_16")
			.get("/asw-junio/img/mapa.jpg")
			.headers(headers_8),
            http("request_17")
			.get("/asw-junio/img/amigos.png")
			.headers(headers_8),
            http("request_18")
			.get("/asw-junio/img/LogoAyuda.jpg")
			.headers(headers_8),
            http("request_19")
			.get("/asw-junio/img/icon/empty-profile.svg")
			.headers(headers_8),
            http("request_20")
			.get("/asw-junio/img/bars-nav.svg")
			.headers(headers_8),
            http("request_21")
			.get("/asw-junio/img/concentric-hex-pattern_2x.png")
			.headers(headers_8),
            http("request_22")
			.get("/manifest.json")
			.headers(headers_6),
            http("request_23")
			.get(uri3 + "/profile/card")
			.headers(headers_23),
            http("request_24")
			.get(uri3 + "/profile/card")
			.headers(headers_23),
            http("request_25")
			.get(uri3 + "/profile/card")
			.headers(headers_25),
            http("request_26")
			.get(uri3 + "/profile/_1593734760000_.jpeg")
			.headers(headers_26),
            http("request_27")
			.get(uri3 + "/public/games/tictactoe/settings.ttl")
			.headers(headers_27)
			.check(status.is(404))))

	setUp(scn.inject(rampUsers(60) during(60 seconds))).protocols(httpProtocol)
}