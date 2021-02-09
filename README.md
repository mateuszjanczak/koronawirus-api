# Koronawirus (Web scraper + API)
Web scraper do pozyskiwania informacji o statystykach koronawirusa ze strony ministerstwa zdrowia.

https://koronawirus-api.herokuapp.com/api/covid19/daily

### Endpointy

### Koronawirus
#### Pobieranie dzisiejszego raportu
```
GET https://koronawirus-api.herokuapp.com/api/covid19/daily
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

#### Pobieranie raportów w danym przedziale czasowym
```
GET https://koronawirus-api.herokuapp.com/api/covid19/from/2021-01-01/to/2021-02-08/
GET https://koronawirus-api.herokuapp.com/api/covid19/from/2021-01-01 00:00/to/2021-02-08 23:59/
```
```json
[
  {
    "reportDate": "2021-01-01T09:15:15.697+0000",
    "allTime": {
      "infections": 1305774,
      "deaths": 28956,
      "recovered": 1040024
    },
    "today": {
      "newInfections": 11008,
      "newDeaths": 400,
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
          "deaths": 9
        },
        {
          "ageRange": "AR51_60",
          "deaths": 29
        },
        {
          "ageRange": "AR61_70",
          "deaths": 100
        },
        {
          "ageRange": "AR71_80",
          "deaths": 108
        },
        {
          "ageRange": "AR81_",
          "deaths": 153
        }
      ],
      "deathGender": {
        "male": 224,
        "female": 176
      }
    }
  },
  {...}
]
```

#### Raporty z wszystkich województw
```
GET https://koronawirus-api.herokuapp.com/api/voivodeship/
```
```json
[
  {
    "voivodeship": "opolskie",
    "reportDate": "2021-02-09T02:47:03.975+0000",
    "general": {
      "population": 986506,
      "infections": 41180,
      "infectionRatioPer10kPopulation": 0.41,
      "deaths": 1042,
      "recovered": 116,
      "quarantine": 2327
    },
    "today": {
      "infections": 40,
      "deaths": 0,
      "test": {
        "all": 563,
        "positive": 46,
        "negative": 511,
        "poz": 1,
        "other": 6
      },
      "deathType": {
        "covid": 0,
        "comorbidities": 0
      }
    }
  },
  {...}
]
```
#### Raporty ze względu na województwo
```
GET https://koronawirus-api.herokuapp.com/api/voivodeship/malopolskie
GET https://koronawirus-api.herokuapp.com/api/voivodeship/małopolskie
```
```json
{
  "voivodeship": "małopolskie",
  "reportDate": "2021-02-09T02:49:00.248+0000",
  "general": {
    "population": 3400577,
    "infections": 113070,
    "infectionRatioPer10kPopulation": 0.24,
    "deaths": 2742,
    "recovered": 241,
    "quarantine": 6261
  },
  "today": {
    "infections": 83,
    "deaths": 0,
    "test": {
      "all": 1211,
      "positive": 95,
      "negative": 1089,
      "poz": 3,
      "other": 27
    },
    "deathType": {
      "covid": 0,
      "comorbidities": 0
    }
  }
}
```

### Szczepienia
#### Pobieranie dzisiejszego raportu
```
GET https://koronawirus-api.herokuapp.com/api/vaccinations/daily
```
```json
{
  "reportDate": "2021-02-08T09:30:08.690+0000",
  "allTime": {
    "vaccinations": 1656708,
    "firstDoses": 1206212,
    "secondDoses": 450496,
    "lostDoses": 3451,
    "adverseReactions": 1405,
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
        "vaccinations": 184761
      },
      {
        "ageType": "AR31_40",
        "vaccinations": 205969
      },
      {
        "ageType": "AR41_50",
        "vaccinations": 285394
      },
      {
        "ageType": "AR51_60",
        "vaccinations": 319358
      },
      {
        "ageType": "AR61_70",
        "vaccinations": 189421
      },
      {
        "ageType": "AR71_75",
        "vaccinations": 68780
      },
      {
        "ageType": "AR75_",
        "vaccinations": 399214
      },
      {
        "ageType": "AR_UNDEFINED",
        "vaccinations": 3811
      },
      {
        "ageType": "AG_FEMALE",
        "vaccinations": 1154621
      },
      {
        "ageType": "AG_MALE",
        "vaccinations": 498958
      },
      {
        "ageType": "AG_UNDEFINED",
        "vaccinations": 3129
      }
    ]
  },
  "today": {
    "vaccinations": 14568,
    "firstDoses": 5020,
    "secondDoses": 9548
  }
}
```

#### Pobieranie raportów w danym przedziale czasowym
```
GET https://koronawirus-api.herokuapp.com/api/vaccinations/from/2021-01-01/to/2021-02-08/
GET https://koronawirus-api.herokuapp.com/api/vaccinations/from/2021-01-01 00:00/to/2021-02-08 23:59/
```
```json
[
  {
    "reportDate": "2021-01-01T09:15:15.697+0000",
    "allTime": {
      "vaccinations": 46204,
      "firstDoses": 46204,
      "secondDoses": 0,
      "lostDoses": 12,
      "adverseReactions": 15,
      "vaccinesDeliveredToPL": null,
      "vaccinesDeliveredToPoints": null,
      "availabilityInStock": null,
      "ageTypes": [
        {
          "ageType": "AR0_17",
          "vaccinations": 4
        },
        {
          "ageType": "AR18_30",
          "vaccinations": 121
        },
        {
          "ageType": "AR31_40",
          "vaccinations": 133
        },
        {
          "ageType": "AR41_50",
          "vaccinations": 133
        },
        {
          "ageType": "AR51_60",
          "vaccinations": 133
        },
        {
          "ageType": "AR61_70",
          "vaccinations": 133
        },
        {
          "ageType": "AR71_75",
          "vaccinations": 133
        },
        {
          "ageType": "AR75_",
          "vaccinations": 133
        },
        {
          "ageType": "AR_UNDEFINED",
          "vaccinations": 23
        },
        {
          "ageType": "AG_FEMALE",
          "vaccinations": 492
        },
        {
          "ageType": "AG_MALE",
          "vaccinations": 573
        },
        {
          "ageType": "AG_UNDEFINED",
          "vaccinations": 0
        }
      ]
    },
    "today": {
      "vaccinations": 10623,
      "firstDoses": 10622,
      "secondDoses": 1
    }
  },
  {...}
]
```