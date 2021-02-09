# Koronawirus (Web scraper + API)
Web scraper do pozyskiwania informacji o statystykach koronawirusa ze strony ministerstwa zdrowia.

https://koronawirus-api.herokuapp.com/api/covid19/daily

### Endpointy

### Koronawirus
#### Raporty - kraj
```
GET https://koronawirus-api.herokuapp.com/api/covid19/daily
GET https://koronawirus-api.herokuapp.com/api/covid19/from/2021-01-01/to/2021-02-08/
GET https://koronawirus-api.herokuapp.com/api/covid19/from/2021-01-01 00:00/to/2021-02-08 23:59/
```
```json
{
  "reportDate": "2021-02-09T09:30:18.061+0000",
  "general": {
    "infections": 1556685,
    "deaths": 39360,
    "recovered": 1317474
  },
  "today": {
    "newInfections": 4029,
    "newDeaths": 227,
    "deathAgeRanges": [
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
        "deaths": 4
      },
      {
        "ageRange": "AR51_60",
        "deaths": 18
      },
      {
        "ageRange": "AR61_70",
        "deaths": 42
      },
      {
        "ageRange": "AR71_80",
        "deaths": 77
      },
      {
        "ageRange": "AR81_",
        "deaths": 85
      }
    ],
    "deathGender": {
      "male": 132,
      "female": 95
    }
  }
}
```

#### Raporty - województwo
```
GET https://koronawirus-api.herokuapp.com/api/covid19/province
GET https://koronawirus-api.herokuapp.com/api/covid19/province/małopolskie
```
```json
{
  "voivodeship": "małopolskie",
  "reportDate": "2021-02-09T19:47:09.551+0000",
  "general": {
    "population": 3400577,
    "infections": 113070,
    "infectionRatioPer10kPopulation": 0.56,
    "deaths": 2742,
    "recovered": 226,
    "quarantine": 6858
  },
  "today": {
    "infections": 191,
    "deaths": 19,
    "test": {
      "all": 2659,
      "positive": 212,
      "negative": 2415,
      "poz": 856,
      "other": 32
    },
    "deathType": {
      "covid": 8,
      "comorbidities": 11
    }
  }
}
```

### Szczepienia
#### Raporty - kraj
```
GET https://koronawirus-api.herokuapp.com/api/vaccinations/daily
GET https://koronawirus-api.herokuapp.com/api/vaccinations/from/2021-01-01/to/2021-02-08/
GET https://koronawirus-api.herokuapp.com/api/vaccinations/from/2021-01-01 00:00/to/2021-02-08 23:59/
```
```json
{
  "reportDate": "2021-02-09T09:30:13.022+0000",
  "general": {
    "vaccinations": 1688465,
    "firstDoses": 1226129,
    "secondDoses": 462336,
    "lostDoses": 3487,
    "adverseReactions": 1487,
    "vaccinesDeliveredToPL": 2432640,
    "vaccinesDeliveredToPoints": 1971810,
    "availabilityInStock": 460830,
    "ageTypes": [
      {
        "ageType": "AR0_17",
        "vaccinations": 0
      },
      {
        "ageType": "AR18_30",
        "vaccinations": 187411
      },
      {
        "ageType": "AR31_40",
        "vaccinations": 208538
      },
      {
        "ageType": "AR41_50",
        "vaccinations": 288425
      },
      {
        "ageType": "AR51_60",
        "vaccinations": 322200
      },
      {
        "ageType": "AR61_70",
        "vaccinations": 192729
      },
      {
        "ageType": "AR71_75",
        "vaccinations": 73050
      },
      {
        "ageType": "AR75_",
        "vaccinations": 412267
      },
      {
        "ageType": "AR_UNDEFINED",
        "vaccinations": 3845
      },
      {
        "ageType": "AG_FEMALE",
        "vaccinations": 1175456
      },
      {
        "ageType": "AG_MALE",
        "vaccinations": 509863
      },
      {
        "ageType": "AG_UNDEFINED",
        "vaccinations": 3146
      }
    ]
  },
  "today": {
    "vaccinations": 30892,
    "firstDoses": 19494,
    "secondDoses": 11398
  }
}
```

#### Raporty - województwo
```
GET https://koronawirus-api.herokuapp.com/api/vaccinations/province
GET https://koronawirus-api.herokuapp.com/api/vaccinations/province/małopolskie
```
```json
{
  "voivodeship": "małopolskie",
  "reportDate": "2021-02-09T19:44:52.291+0000",
  "general": {
    "population": 3400577,
    "vaccinations": 136981,
    "firstDoses": 103418,
    "secondDoses": 33563
  },
  "today": {
    "vaccinations": 3362,
    "firstDoses": 2258,
    "secondDoses": 1104
  }
}
```