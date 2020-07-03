
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CargarRuta50PorSegundo extends Simulation {

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
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000")

	val headers_7 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin")

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
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjI2NCwiaWF0IjoxNTkzNzUyNjY0LCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.shzo8_3F27wYzJZ7V9kSD8fUO2TjiBB-07wwKnHWjD_09QVo_c8pocWDCAbCPkJQBOsEpYqIWNcysLgkalbqioJWOK1-MZ7UOB6jCDkZb9ovZu3ozN1fPB4KqwbWTdF5IXLUA56lnbrqziRvAA22O3kPVc5rwQwt3qPvQJq1fAIMZz-rawFhxJNAJw0ZXy47SwqA8iMent-eyFaK-ClAKjFkLk3YHQOnZ-S8kHoEXNNDtQY_a4XHg6XsnxJUkjSUZywpfSIxAdIhVmKI3GswIEXuAQI5HzR2b5QBW0ztJvjKqoKGeaQ_sIkgms76C7Ast4t0uqznxcSKSwWrnO0_BA")

	val headers_25 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"accept" -> "application/trig,application/ld+json;q=0.9,text/html;q=0.8,application/xhtml+xml;q=0.72,application/n-quads;q=0.7,*/*;q=0.1",
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjI2NSwiaWF0IjoxNTkzNzUyNjY1LCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.C0IFSewDiYBUhXUtg8gc04okwgMkpKg97x6h_3ePm9kAKiAzlPO86NvMt9KhavRsR1rSz4iA6xYYe0rMnw5uy6QbqWf8uDGZ-qa8-6z3UC4G2qcLovUSov7atZFUjJQ3wzOpbfYbwdgozmP68KWJ83Enrz3QQllgM8oofAu02t4fbQWLhFDAB5CJTsNdzBbKOTVv76pl_IKvz-4q-pa2mSk0EgrMtY5JjlwHb3ig9Ky-ZuC5YYeFsayXObziMAZTETk-iYb00FcxS0I1Q8sdudQP8TrZkTSYbTPXfvpOXMwjqRYMF6cD7iBtpdlEVcyoZemCxv0JCvhhASJmgmsCxw")

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
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjI2NSwiaWF0IjoxNTkzNzUyNjY1LCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.C0IFSewDiYBUhXUtg8gc04okwgMkpKg97x6h_3ePm9kAKiAzlPO86NvMt9KhavRsR1rSz4iA6xYYe0rMnw5uy6QbqWf8uDGZ-qa8-6z3UC4G2qcLovUSov7atZFUjJQ3wzOpbfYbwdgozmP68KWJ83Enrz3QQllgM8oofAu02t4fbQWLhFDAB5CJTsNdzBbKOTVv76pl_IKvz-4q-pa2mSk0EgrMtY5JjlwHb3ig9Ky-ZuC5YYeFsayXObziMAZTETk-iYb00FcxS0I1Q8sdudQP8TrZkTSYbTPXfvpOXMwjqRYMF6cD7iBtpdlEVcyoZemCxv0JCvhhASJmgmsCxw")

	val headers_36 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en,es-ES;q=0.9,es;q=0.8",
		"sec-fetch-dest" -> "script",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site",
		"x-client-data" -> "CIm2yQEIpLbJAQjEtskBCKmdygEI6MjKARibvsoB")

	val headers_48 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en,es-ES;q=0.9,es;q=0.8",
		"Origin" -> "http://localhost:3000",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"authorization" -> "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiIxNDQ5YzQ0YjM2MzY5NmU5MjQ0OGEwMGM4ZDUwYWVkNSIsImF1ZCI6Imh0dHBzOi8vZXJpY2NjLnNvbGlkLmNvbW11bml0eSIsImV4cCI6MTU5Mzc1NjI2OCwiaWF0IjoxNTkzNzUyNjY4LCJpZF90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW10cFpDSTZJbTAyYUdSclNuUjVRVXBOSW4wLmV5SnBjM01pT2lKb2RIUndjem92TDNOdmJHbGtMbU52YlcxMWJtbDBlU0lzSW5OMVlpSTZJbWgwZEhCek9pOHZaWEpwWTJOakxuTnZiR2xrTG1OdmJXMTFibWwwZVM5d2NtOW1hV3hsTDJOaGNtUWpiV1VpTENKaGRXUWlPaUl4TkRRNVl6UTBZak0yTXpZNU5tVTVNalEwT0dFd01HTTRaRFV3WVdWa05TSXNJbVY0Y0NJNk1UVTRPVGd5T1RnME1Dd2lhV0YwSWpveE5UZzROakl3TWpRd0xDSnFkR2tpT2lKbFltTTVZMk5sWW1Gak5tTmpNVFF4SWl3aWJtOXVZMlVpT2lJM04zUndhRVZJYmtkU1MzZHVWWFJUVDFRdGNIcDJTVWRqWWprMmVEQlBXV0UzZUVKVWJXdGxNV3RuSWl3aVlYcHdJam9pTVRRME9XTTBOR0l6TmpNMk9UWmxPVEkwTkRoaE1EQmpPR1ExTUdGbFpEVWlMQ0pqYm1ZaU9uc2lhbmRySWpwN0ltRnNaeUk2SWxKVE1qVTJJaXdpWlNJNklrRlJRVUlpTENKbGVIUWlPblJ5ZFdVc0ltdGxlVjl2Y0hNaU9sc2lkbVZ5YVdaNUlsMHNJbXQwZVNJNklsSlRRU0lzSW00aU9pSXhTblk1WTJ4d2RFUkxhQzAyZG5kclFqbEViVlZ4WlVGdlMzcENUbEV6Ulhsc1ZYazJVMG80VlMxb1pWb3dRbEE1YTJWTVJVaDZRak56T1dkT1VEUndMVFI1YVdwMVgzbHlMVzVEY3pRemRWOTFjM280YURsNlMwOXBSM1pTUkUxYVIzSkJSWEptU0RCaWJIbDZURTkzWlhaQlZ6QjNZMnRHYWpSRWRXeHZhR1o0YUhJd1VUTklabkpPTVZWRE9VZ3RPV1l6UlVKT05rNWpVWHBHZFhCSVJGZEJORlJ4Wm10VlQzVklWRmhNVTI5RFkweERNbTE2YmpobFRWTlZRVFUyUVdVMVMxbG5kWEJYVHpGdFgwRkVVVXhSVUhoRWRISTRRazVGWjJaSGRVTmFielJuVW1ob1dtSjFVMlpZUm1sS1RrTldZVFpWWlcwMmFsQldWMko0ZDIxS2JHRmpaRk0xWlRGM2EzWnJUV2hFWm5wUFRXSlFZMFJ4VGtSRmJWcGFjbE5zVGxkVVVsWnVUemx5ZG0wd01HVjFjV1oxZGxCVGNrOVlNV1pZWVMxTlNGVk1ZakJzVUZCcFdVWktOVEZRWm0xUlFsRWlmWDBzSW1GMFgyaGhjMmdpT2lJd1NFRnhNMk10UTFNelpIbHZWbmhyY1dsaFMyNW5JbjAuY09ISVpDYllmLWZvcm9SRy11dE15dHBnLUNXT0cwbG1wOFpXOHdZY0diZVBUZHZCbVc1UXJJMkFPNmVXWmNMZXl2cTlvM1RMQUhlOGlwRG9qMnNHd3Ixa1IzY3RXanVlU2tBbU5qTG5YNklmdGVkcVg1dnlUazRXOHBYVWZQMXNsTnVFZXhkTlZOUmFmR0ZoOTg3VGVSMEl5TWtkZVVGZ2lUU01uS2tCQUlkVnU3cjI5M2JtWktTRDdDb3NpZVcwTmhRS1dDZ25JTGlxdm53SGdZUGNiQUVrX1RFM1hIRlhMZmRCaDdNcUxoTnpxM2J5SW1KZ2JoaktCdUEtVVlJeGltU0V2Vy1YYURNTzZtdG4xNEY0UEM4aWRKODhJUjFqc2h1Zk5DNGxEQmhxWFY3TW9VVGxMd3pYOVNLUWtocC1xSEs1S09SR2JjNEFMUjY4elRFM3JBIiwidG9rZW5fdHlwZSI6InBvcCJ9.pbELdsa6AYL5YUa33-gylnVr5DSBMB0BS1vD6SmQq_vRumyZQ-b_Hqp-xBFOZzXnP_6DzMJoCM05LgC9p1jRzMj-f_UenXp_RtQCvIlC_vSPAPpBXo6ZMI3srd8Aq4yBQqIlNEeeR9SuR2oRNcmi8SxGSLbRTNIHnVcUKR8wSJ-zFqrIKAvdXxEgIvaKgmeeDu5SzG1ivtk8XLSG7aqwelWfJjnMGtfkC97duSjAZiDvWpnJWs0HcDjRjtA3GNNAdK3ZlEDzOBRVxnyUuNMOKg_m443MVNQxC1_FeNv9MVSdm42CmoUFoj-c8CcwU6_jjTvxQSdI8gKVCJ-5Yq8F5w")

    val uri1 = "https://maps.googleapis.com"
    val uri2 = "http://192.168.8.101:3000/sockjs-node/info"
    val uri4 = "https://ericcc.solid.community"
    val uri5 = "https://maps.gstatic.com/mapfiles"
    val uri6 = "https://fonts.gstatic.com/s"
    val uri7 = "https://fonts.googleapis.com"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/asw-junio/welcome")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri7 + "/css2?family=Amatic+SC&display=swap")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0001_response.css"))),
            http("request_2")
			.get(uri7 + "/css?family=Raleway:400,400i,700,700i|Roboto:300,300i,400,400i,700,700i")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0002_response.css"))),
            http("request_3")
			.get("/asw-junio/locales/en-US/translation.json")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0003_response.html"))),
            http("request_4")
			.get("/asw-junio/locales/en/translation.json")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0004_response.html"))),
            http("request_5")
			.get("/asw-junio/locales/es/translation.json")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0005_response.html"))),
            http("request_6")
			.get(uri2 + "?t=1593752664851")
			.headers(headers_6)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0006_response.json"))),
            http("request_7")
			.get("/sockjs-node/info?t=1593752664852")
			.headers(headers_7)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0007_response.json"))),
            http("request_8")
			.get("/img/mountain2.jpg")
			.headers(headers_8)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0008_response.jpeg"))),
            http("request_9")
			.get(uri6 + "/raleway/v16/1Ptrg8zYS_SKggPNwJYtWqZPAA.woff2")
			.headers(headers_9)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0009_response.dat"))),
            http("request_10")
			.get(uri6 + "/roboto/v20/KFOlCnqEu92Fr1MmSU5fBBc4.woff2")
			.headers(headers_9)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0010_response.dat"))),
            http("request_11")
			.get(uri6 + "/raleway/v16/1Ptug8zYS_SKggPNyC0ITw.woff2")
			.headers(headers_9)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0011_response.dat"))),
            http("request_12")
			.get(uri6 + "/roboto/v20/KFOmCnqEu92Fr1Mu4mxK.woff2")
			.headers(headers_9)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0012_response.dat"))),
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
			.headers(headers_7)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0022_response.json"))),
            http("request_23")
			.get(uri4 + "/profile/card")
			.headers(headers_23)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0023_response.ttl"))),
            http("request_24")
			.get(uri4 + "/profile/card")
			.headers(headers_23)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0024_response.ttl"))),
            http("request_25")
			.get(uri4 + "/profile/card")
			.headers(headers_25)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0025_response.ttl"))),
            http("request_26")
			.get(uri4 + "/profile/_1593734760000_.jpeg")
			.headers(headers_26)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0026_response.jpeg"))),
            http("request_27")
			.get(uri4 + "/public/games/tictactoe/settings.ttl")
			.headers(headers_27)
			.check(status.is(404))
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0027_response.txt"))))
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0000_response.html"))))
		.pause(1)
		.exec(http("request_28")
			.get("/asw-junio/img/logoNav.jpg")
			.headers(headers_8)
			.resources(http("request_29")
			.get("/asw-junio/img/icon/apps.svg")
			.headers(headers_8),
            http("request_30")
			.get("/asw-junio/img/people.svg")
			.headers(headers_8),
            http("request_31")
			.get("/asw-junio/img/mapa.jpg")
			.headers(headers_8),
            http("request_32")
			.get("/asw-junio/img/amigos.png")
			.headers(headers_8),
            http("request_33")
			.get("/asw-junio/img/LogoAyuda.jpg")
			.headers(headers_8),
            http("request_34")
			.get("/asw-junio/img/icon/empty-profile.svg")
			.headers(headers_8),
            http("request_35")
			.get("/asw-junio/img/bars-nav.svg")
			.headers(headers_8),
            http("request_36")
			.get(uri1 + "/maps/api/js?key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&callback=loaderCB01593752668223&libraries=places&v=3&language=en")
			.headers(headers_36)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0036_response.dat"))),
            http("request_37")
			.get(uri1 + "/maps-api-v3/api/js/40/12/common.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0037_response.dat"))),
            http("request_38")
			.get(uri1 + "/maps-api-v3/api/js/40/12/util.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0038_response.dat"))),
            http("request_39")
			.get(uri1 + "/maps-api-v3/api/js/40/12/map.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0039_response.dat"))),
            http("request_40")
			.get(uri1 + "/maps-api-v3/api/js/40/12/geometry.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0040_response.dat"))),
            http("request_41")
			.get(uri1 + "/maps-api-v3/api/js/40/12/poly.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0041_response.dat"))),
            http("request_42")
			.get(uri5 + "/openhand_8_8.cur")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0042_response.bmp"))),
            http("request_43")
			.get(uri1 + "/maps-api-v3/api/js/40/12/stats.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0043_response.dat"))),
            http("request_44")
			.get(uri1 + "/maps-api-v3/api/js/40/12/onion.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0044_response.dat"))),
            http("request_45")
			.get(uri5 + "/transparent.png")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0045_response.png"))),
            http("request_46")
			.get(uri5 + "/undo_poly.png")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0046_response.png"))),
            http("request_47")
			.get(uri1 + "/maps-api-v3/api/js/40/12/infowindow.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0047_response.dat"))),
            http("request_48")
			.get(uri4 + "/profile/card")
			.headers(headers_48)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0048_response.ttl"))),
            http("request_49")
			.get(uri1 + "/maps/api/js/ViewportInfoService.GetViewportInfo?1m6&1m2&1d43.33181985981567&2d-5.926447669528102&2m2&1d43.38805490045092&2d-5.763184648328981&2u15&4sen&5e0&6sm%40519000000&7b0&8e0&callback=_xdc_._l2ezrg&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=92830")
			.headers(headers_36)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0049_response.dat"))),
            http("request_50")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15852!3i11995!4i256!2m3!1e0!2sm!3i519234908!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=127032")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0050_response.png"))),
            http("request_51")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15851!3i11995!4i256!2m3!1e0!2sm!3i519234908!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=109700")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0051_response.png"))),
            http("request_52")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15851!3i11994!4i256!2m3!1e0!2sm!3i519234908!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=111664")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0052_response.png"))),
            http("request_53")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15852!3i11994!4i256!2m3!1e0!2sm!3i519234908!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=128996")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0053_response.png"))),
            http("request_54")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15853!3i11994!4i256!2m3!1e0!2sm!3i519234860!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=65431")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0054_response.png"))),
            http("request_55")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15853!3i11995!4i256!2m3!1e0!2sm!3i519234860!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=63467")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0055_response.png"))),
            http("request_56")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15853!3i11996!4i256!2m3!1e0!2sm!3i519234860!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=61503")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0056_response.png"))),
            http("request_57")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15852!3i11996!4i256!2m3!1e0!2sm!3i519234896!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=29662")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0057_response.png"))),
            http("request_58")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15851!3i11996!4i256!2m3!1e0!2sm!3i519234896!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=12330")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0058_response.png"))),
            http("request_59")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15850!3i11996!4i256!2m3!1e0!2sm!3i519234896!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=126069")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0059_response.png"))),
            http("request_60")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15850!3i11995!4i256!2m3!1e0!2sm!3i519234908!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=92368")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0060_response.png"))),
            http("request_61")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15850!3i11994!4i256!2m3!1e0!2sm!3i519234908!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=94332")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0061_response.png"))),
            http("request_62")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15854!3i11994!4i256!2m3!1e0!2sm!3i519234836!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=61423")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0062_response.png"))),
            http("request_63")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15854!3i11995!4i256!2m3!1e0!2sm!3i519234824!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=20605")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0063_response.png"))),
            http("request_64")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15854!3i11996!4i256!2m3!1e0!2sm!3i519234812!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=110858")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0064_response.png"))),
            http("request_65")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15849!3i11996!4i256!2m3!1e0!2sm!3i519234860!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=82655")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0065_response.png"))),
            http("request_66")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15849!3i11995!4i256!2m3!1e0!2sm!3i519234860!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=84619")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0066_response.png"))),
            http("request_67")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15849!3i11994!4i256!2m3!1e0!2sm!3i519234860!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjJ8cC52Om9mZixzLnQ6NnxwLnM6MTAwfHAubDotNg!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=86583")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0067_response.png"))),
            http("request_68")
			.get(uri4 + "/inbox")
			.headers(headers_48),
            http("request_69")
			.get(uri1 + "/maps-api-v3/api/js/40/12/controls.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0069_response.dat"))),
            http("request_70")
			.get(uri7 + "/css?family=Roboto:300,400,500,700|Google+Sans:400,500,700")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0070_response.css"))),
            http("request_71")
			.get(uri5 + "/api-3/images/google_white5.png")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0071_response.png"))),
            http("request_72")
			.get(uri1 + "/maps-api-v3/api/js/40/12/marker.js")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0072_response.dat"))),
            http("request_73")
			.get(uri6 + "/roboto/v20/KFOlCnqEu92Fr1MmEU9fBBc4.woff2")
			.headers(headers_9)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0073_response.dat"))),
            http("request_74")
			.get(uri1 + "/maps/api/js/AuthenticationService.Authenticate?1shttp%3A%2F%2Flocalhost%3A3000%2Fasw-junio%2Fmap&4sAIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&callback=_xdc_._himuvt&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=2078")
			.headers(headers_36)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0074_response.dat"))),
            http("request_75")
			.get(uri1 + "/maps/api/js/QuotaService.RecordEvent?1shttp%3A%2F%2Flocalhost%3A3000%2Fasw-junio%2Fmap&3sAIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&7s5r6tnx&10e1&callback=_xdc_._mzw3j0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=78618")
			.headers(headers_36)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0075_response.dat"))),
            http("request_76")
			.get(uri5 + "/api-3/images/google_gray.svg")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0076_response.svg"))),
            http("request_77")
			.get(uri4 + "/public/games/tictactoe/settings.ttl")
			.headers(headers_48)
			.check(status.is(404))
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0077_response.txt"))),
            http("request_78")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15852!3i11995!4i256!2m3!1e0!2sm!3i519234908!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=108689")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0078_response.png"))),
            http("request_79")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15851!3i11995!4i256!2m3!1e0!2sm!3i519234908!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=12061")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0079_response.png"))),
            http("request_80")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15851!3i11994!4i256!2m3!1e0!2sm!3i519234908!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=54349")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0080_response.png"))),
            http("request_81")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15852!3i11994!4i256!2m3!1e0!2sm!3i519234908!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=19906")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0081_response.png"))),
            http("request_82")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15853!3i11994!4i256!2m3!1e0!2sm!3i519234860!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=112520")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0082_response.png"))),
            http("request_83")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15853!3i11995!4i256!2m3!1e0!2sm!3i519234860!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=70232")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0083_response.png"))),
            http("request_84")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15853!3i11996!4i256!2m3!1e0!2sm!3i519234860!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=27944")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0084_response.png"))),
            http("request_85")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15852!3i11996!4i256!2m3!1e0!2sm!3i519234896!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=14530")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0085_response.png"))),
            http("request_86")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15851!3i11996!4i256!2m3!1e0!2sm!3i519234896!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=48973")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0086_response.png"))),
            http("request_87")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15850!3i11996!4i256!2m3!1e0!2sm!3i519234896!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=83416")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0087_response.png"))),
            http("request_88")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15850!3i11995!4i256!2m3!1e0!2sm!3i519234908!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=46504")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0088_response.png"))),
            http("request_89")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15850!3i11994!4i256!2m3!1e0!2sm!3i519234908!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=88792")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0089_response.png"))),
            http("request_90")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15854!3i11994!4i256!2m3!1e0!2sm!3i519234836!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=114314")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0090_response.png"))),
            http("request_91")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15854!3i11995!4i256!2m3!1e0!2sm!3i519234824!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=44288")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0091_response.png"))),
            http("request_92")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15854!3i11996!4i256!2m3!1e0!2sm!3i519234812!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=105333")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0092_response.png"))),
            http("request_93")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15849!3i11996!4i256!2m3!1e0!2sm!3i519234860!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=129141")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0093_response.png"))),
            http("request_94")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15849!3i11995!4i256!2m3!1e0!2sm!3i519234860!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=40358")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0094_response.png"))),
            http("request_95")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i15!2i15849!3i11994!4i256!2m3!1e0!2sm!3i519234860!2m3!1e2!6m1!3e5!3m17!2sen!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcC5zOi02MHxwLmw6LTYw!4e0&key=AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8&token=82646")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0095_response.png"))),
            http("request_96")
			.get(uri4 + "/asw/rutas.json")
			.headers(headers_48)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0096_response.txt"))),
            http("request_97")
			.get(uri4 + "/inbox/")
			.headers(headers_48)
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0097_response.ttl")))))
		.pause(2)
		.exec(http("request_98")
			.get(uri5 + "/api-3/images/spotlight-poi2.png")
			.check(bodyBytes.is(RawFileBody("/recordedsimulation/0098_response.png"))))

	setUp(scn.inject(rampUsers(3000) during(60 seconds))).protocols(httpProtocol)
}