# Koronawirus (Web scraper + API)
Web scraper do pozyskiwania informacji o statystykach koronawirusa ze strony ministerstwa zdrowia.

https://koronawirus-api.herokuapp.com/api/covid19/daily

### Endpointy

#### Pobieranie dzisiejszego raportu


```
GET http://127.0.0.1:8080/api/covid19/daily
```
```json
{
    "reportDate": "2021-02-07T09:30:12.528+0000",
    "allTime": {
        "infections": 1550255,
        "deaths": 39087,
        "recovered": 1307161
    },
    "today": {
        "newInfections": 4728,
        "newDeaths": 93,
        "deathAgeRange": [
            {
                "ageRange": "AR0_10",
                "deaths": 0
            },
            {
                "ageRange": "AR11_20",
                "deaths": 0
            },
            {
                "ageRange": "AR21_30",
                "deaths": 0
            },
            {
                "ageRange": "AR31_40",
                "deaths": 1
            },
            {
                "ageRange": "AR41_50",
                "deaths": 2
            },
            {
                "ageRange": "AR51_60",
                "deaths": 3
            },
            {
                "ageRange": "AR61_70",
                "deaths": 24
            },
            {
                "ageRange": "AR71_80",
                "deaths": 24
            },
            {
                "ageRange": "AR81_",
                "deaths": 39
            }
        ],
        "deathGender": {
            "male": 56,
            "female": 37
        }
    }
}
```
