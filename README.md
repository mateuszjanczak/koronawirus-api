# Koronawirus (Web scraper + API)
Web scraper do pozyskiwania informacji o statystykach koronawirusa ze strony ministerstwa zdrowia.

https://koronawirus-api.herokuapp.com/api

### Endpointy
#### Pobieranie raportów

```
GET http://localhost:8080/api/

Zwracany
[
    {
        "id": 0,
        "wojewodztwo": "Polska",
        "zarazeni": 425,
        "martwi": 5
    },
    {
        "id": 1,
        "wojewodztwo": "dolnośląskie",
        "zarazeni": 58,
        "martwi": 2
    },
    {
        "id": 2,
        "wojewodztwo": "kujawsko-pomorskie",
        "zarazeni": 14,
        "martwi": 0
    },
    (...)
]
```

#### Pobieranie pojedynczego raportu przez id lub nazwę województwa

```
GET http://localhost:8080/api/id/{id}
GET http://localhost:8080/api/wojewodztwo/{wojewodztwo}

Zwracany
{
    "id": 2,
    "wojewodztwo": "kujawsko-pomorskie",
    "zarazeni": 14,
    "martwi": 0
}

```
