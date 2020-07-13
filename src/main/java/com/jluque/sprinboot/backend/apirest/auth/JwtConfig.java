package com.jluque.sprinboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEpAIBAAKCAQEAoKOZXEBnexwnTgdKoDkUV0bijEHBM6zvk1nx55Dtcb4B1njx\n" + 
			"shGncdkLLjCNi10tkV4FsVcJu58vFblZfwRS9HeS5h5tyUsWmbReamO9GOg6rswl\n" + 
			"Ro43jYLa0DOw3bazq20YYkDAtDDpXM0uxnYbfWxQB7ykrU9WrgL5SJR6gUS7g6ro\n" + 
			"oHaaMHr0vJKHb0PEq6bQR96VeJlKpBeFIsWu2supxHg2fCbAOpII8YT5UsMTy8o/\n" + 
			"4A1ld8JUp1C9h/lwukb2YH4uWk7p/W+yiDab4gmIR9BNVOMDt568ANldtMNWQ5Wt\n" + 
			"Ql6UkzVxEx9HXgMhJ/AVh7AknOdu+KrsY5UA2QIDAQABAoIBAHWaL81MzTVg0Bmc\n" + 
			"1vJjt1OJ7pM2FGZrhd0/bQzVmi+6JghI9NEjgY2kkz3Wh9ludszEo7BIAzUbfdIO\n" + 
			"psmJdd3JqH7V6hQC5+HRHYoPyMFySnvrsqJrvZnZIa5pGWPHvNOUg9RyiWGhqUaq\n" + 
			"ZEMg9lElOZXgckL7IX81aCDNqr31VXm5+edcnaQhHSK9DNMl/9cyKiiGA3D16y/8\n" + 
			"pGc7nVMCJVvJK+mf8j4uxPNB3OsXWpodhGNtt1PIp5XrEeI1bA+p8De7uzYQZHy7\n" + 
			"d/ZXrfzDVc8PUx5pF+SS9740kxGmsoKOOl+otpvjH/CrOddn0hJYuw9eUX8KDc9w\n" + 
			"0CwOuY0CgYEA1MRKB8RK520COTYGu7OW8WjdMwUnnWuMzY7qt3kl+YXQUKdhySTR\n" + 
			"7C6Wqut+9Qq4GRm4aClBAaoSyS0f3sarbg7e8O8BM1a2OoX2uSNDUqNP/qsks9MK\n" + 
			"HVT7iHPUPozx1EjGn2wc2MKc50/imyVgpOn5RSstNav9n2iTEvAc4msCgYEAwUe6\n" + 
			"oFLGRGmi42JAetlByVXjo8msl10Mw+irzmIx93g18qG+1/8z8KEZBa+ie/dNVzKS\n" + 
			"wqYtX0woOvbgaic8VlZzq26ukg1IZC9h8RZ0Mw02n7cuumG1m7QoFaCklP4YP0WY\n" + 
			"TMAaRQYOKfIhnONz3BXz98PGpMoVLg4N5Sch4ssCgYEAxyrHseWJyIE+Z5evTd2b\n" + 
			"GnhzN+NHZhDbSUDTbtQ1PBKLIjTNUKDq8Q/bcjvoKDHUi4qMGNUlSQ2PcEqRXtTS\n" + 
			"fL/m6dqRYSF2i+oDPuNHjf/aTiaewMZ43WRD4UOsFrGRXoqRg4KMrkve3JjnIxwm\n" + 
			"D7oF4T29oFRTofkeU8f5AekCgYArotITmByDHYZU572+/oXHushmFgYNNkjHgiQn\n" + 
			"uCunv1AOs02u3kMPtI89pWV9r1uasCRKJdJgjYUXqt0HmkwZAfOjZJ2tA6qwU7I9\n" + 
			"B+C8FeObM3QtSBoESSwzlc0ShjtbLY8w5L4Jj1BrT+sezIs/yQUHjv+t/KHDgBDL\n" + 
			"B4ay+QKBgQDDzY7wv8grmnQRI3uFoP8mCyj1A0mh1V6wiKs/Hb7bfrtBzQPAzOsc\n" + 
			"UUQMpjK5I8tXz/gD2nZaYCcY5wq4+QycEqPsoUJAhMCgltJLV2o2/qvtxmeIUEO1\n" + 
			"F64wz2Tr1+aoPwWwWlSmVt0XDzAaIJl9XwnuKdlyhI0OCvUu6v0+RA==\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoKOZXEBnexwnTgdKoDkU\n" + 
			"V0bijEHBM6zvk1nx55Dtcb4B1njxshGncdkLLjCNi10tkV4FsVcJu58vFblZfwRS\n" + 
			"9HeS5h5tyUsWmbReamO9GOg6rswlRo43jYLa0DOw3bazq20YYkDAtDDpXM0uxnYb\n" + 
			"fWxQB7ykrU9WrgL5SJR6gUS7g6rooHaaMHr0vJKHb0PEq6bQR96VeJlKpBeFIsWu\n" + 
			"2supxHg2fCbAOpII8YT5UsMTy8o/4A1ld8JUp1C9h/lwukb2YH4uWk7p/W+yiDab\n" + 
			"4gmIR9BNVOMDt568ANldtMNWQ5WtQl6UkzVxEx9HXgMhJ/AVh7AknOdu+KrsY5UA\n" + 
			"2QIDAQAB\n" + 
			"-----END PUBLIC KEY-----";
}
