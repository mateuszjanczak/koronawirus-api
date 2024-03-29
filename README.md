# Koronawirus (Web scraper + API)

[![Uptime Robot status](https://badgen.net/uptime-robot/status/m787258660-5597da29bb779a9b5030bf08)](https://stats.uptimerobot.com/vmO9EsWJBx)
[![Uptime Robot day](https://badgen.net/uptime-robot/day/m787258660-5597da29bb779a9b5030bf08)](https://stats.uptimerobot.com/vmO9EsWJBx)
[![Uptime Robot week](https://badgen.net/uptime-robot/week/m787258660-5597da29bb779a9b5030bf08)](https://stats.uptimerobot.com/vmO9EsWJBx)
[![Uptime Robot month](https://badgen.net/uptime-robot/month/m787258660-5597da29bb779a9b5030bf08)](https://stats.uptimerobot.com/vmO9EsWJBx)
[![Uptime Robot response](https://badgen.net/uptime-robot/response/m787258660-5597da29bb779a9b5030bf08)](https://stats.uptimerobot.com/vmO9EsWJBx)

Web scraper do pozyskiwania informacji o statystykach koronawirusa ze strony ministerstwa zdrowia.

Dane są odświeżane co 15 minut.

https://koronawirus-api.koyeb.app/api/covid19/daily  

### Endpointy

### Koronawirus

#### Raport zbiorczy o covidzie, testach i szczepieniach

```
GET https://koronawirus-api.koyeb.app/api/covid-vaccinations-tests/daily
```

```json
{
  "reportDate": "2021-09-17T08:30:33.471+0000",
  "general": {
    "vaccinations": {
      "vaccinations": 36878694,
      "firstDoses": 19601546,
      "secondDoses": 17277148,
      "lostDoses": 391290,
      "adverseReactions": 15278,
      "vaccinesDeliveredToPL": 53910230,
      "vaccinesDeliveredToPoints": 38488580,
      "availabilityInStock": 9740010,
      "ordersInProgress": 679440,
      "ageTypes": [
        {
          "ageType": "AR0_17",
          "vaccinations": 1454707
        },
        {
          "ageType": "AR18_30",
          "vaccinations": 4594417
        },
        {
          "ageType": "AR31_40",
          "vaccinations": 5409113
        },
        {
          "ageType": "AR41_50",
          "vaccinations": 6197161
        },
        {
          "ageType": "AR51_60",
          "vaccinations": 5563630
        },
        {
          "ageType": "AR61_70",
          "vaccinations": 7243381
        },
        {
          "ageType": "AR71_75",
          "vaccinations": 2847452
        },
        {
          "ageType": "AR75_",
          "vaccinations": 3452721
        },
        {
          "ageType": "AR_UNDEFINED",
          "vaccinations": 116112
        },
        {
          "ageType": "AG_FEMALE",
          "vaccinations": 19683665
        },
        {
          "ageType": "AG_MALE",
          "vaccinations": 17078902
        },
        {
          "ageType": "AG_UNDEFINED",
          "vaccinations": 116127
        }
      ]
    },
    "infections": {
      "infections": 2896599,
      "deaths": 75473,
      "recovered": 2658812
    },
    "tests": {
      "infections": 2896599,
      "deaths": 75473,
      "recovered": 2658812,
      "quarantine": 82237
    }
  },
  "today": {
    "vaccinations": {
      "vaccinations": 34076,
      "firstDoses": 17614,
      "secondDoses": 16462
    },
    "infections": {
      "newInfections": 652,
      "newDeaths": 8,
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
          "deaths": 0
        },
        {
          "ageRange": "AR41_50",
          "deaths": 0
        },
        {
          "ageRange": "AR51_60",
          "deaths": 0
        },
        {
          "ageRange": "AR61_70",
          "deaths": 1
        },
        {
          "ageRange": "AR71_80",
          "deaths": 5
        },
        {
          "ageRange": "AR81_",
          "deaths": 2
        }
      ],
      "deathGender": {
        "male": 6,
        "female": 2
      }
    },
    "tests": {
      "infections": 652,
      "deaths": {
        "deaths": 8,
        "covid": 2,
        "coexistent": 6
      },
      "recovered": 498,
      "tests": {
        "all": 35959,
        "positive": 736,
        "poz": 5452
      }
    }
  }
}
```

#### Raporty - kraj

```
GET https://koronawirus-api.koyeb.app/api/covid19/daily
GET https://koronawirus-api.koyeb.app/api/covid19/from/2021-01-01/to/2021-02-08/
GET https://koronawirus-api.koyeb.app/api/covid19/from/2021-01-01 00:00/to/2021-02-08 23:59/
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
GET https://koronawirus-api.koyeb.app/api/covid19/province
GET https://koronawirus-api.koyeb.app/api/covid19/province/małopolskie
```

```json
{
  "province": "małopolskie",
  "reportDate": "2021-02-09T22:30:18.950+0000",
  "general": {
    "population": 3400577,
    "infections": 113070,
    "deaths": 2742,
    "recovered": 226,
    "quarantine": 6858
  },
  "today": {
    "infections": 191,
    "infectionRatioPer10kPopulation": 0.56,
    "tests": {
      "all": 2659,
      "positive": 212,
      "negative": 2415,
      "poz": 856,
      "other": 32
    },
    "deaths": {
      "deaths": 19,
      "covid": 8,
      "coexistent": 11
    }
  }
}
```

#### Raporty - powiat

```
GET https://koronawirus-api.koyeb.app/api/covid19/district
GET https://koronawirus-api.koyeb.app/api/covid19/district/powiat tarnowski
```

```json
{
  "district": "powiat tarnowski",
  "province": "małopolskie",
  "reportDate": "2021-02-09T22:31:28.762+0000",
  "general": {
    "population": 201570,
    "quarantine": 230
  },
  "today": {
    "infections": 10,
    "infectionRatioPer10kPopulation": 0.5,
    "recovered": 0,
    "deaths": {
      "deaths": 0,
      "covid": 0,
      "coexistent": 0
    },
    "tests": {
      "all": 130,
      "positive": 10,
      "negative": 119,
      "poz": 32,
      "other": 1
    }
  }
}
```

### Testy

### Raporty - kraj

```
GET https://koronawirus-api.koyeb.app/api/tests/daily
```

```json
{
  "reportDate": "2021-09-17T08:30:33.965+0000",
  "general": {
    "infections": 2896599,
    "deaths": 75473,
    "recovered": 2658812,
    "quarantine": 82237
  },
  "today": {
    "infections": 652,
    "deaths": {
      "deaths": 8,
      "covid": 2,
      "coexistent": 6
    },
    "recovered": 498,
    "tests": {
      "all": 35959,
      "positive": 736,
      "poz": 5452
    }
  }
}
```

### Szczepienia

#### Raporty - kraj

```
GET https://koronawirus-api.koyeb.app/api/vaccinations/daily
GET https://koronawirus-api.koyeb.app/api/vaccinations/from/2021-01-01/to/2021-02-08/
GET https://koronawirus-api.koyeb.app/api/vaccinations/from/2021-01-01 00:00/to/2021-02-08 23:59/
```

```json
{
  "reportDate": "2021-03-19T09:30:14.753+0000",
  "general": {
    "vaccinations": 4893320,
    "firstDoses": 3162971,
    "secondDoses": 1730349,
    "lostDoses": 5879,
    "adverseReactions": 5034,
    "vaccinesDeliveredToPL": 5728100,
    "vaccinesDeliveredToPoints": 4904750,
    "availabilityInStock": 203270,
    "ordersInProgress": 620080,
    "ageTypes": [
      {
        "ageType": "AR0_17",
        "vaccinations": 1019
      },
      {
        "ageType": "AR18_30",
        "vaccinations": 325124
      },
      {
        "ageType": "AR31_40",
        "vaccinations": 427710
      },
      {
        "ageType": "AR41_50",
        "vaccinations": 589842
      },
      {
        "ageType": "AR51_60",
        "vaccinations": 608117
      },
      {
        "ageType": "AR61_70",
        "vaccinations": 558038
      },
      {
        "ageType": "AR71_75",
        "vaccinations": 691961
      },
      {
        "ageType": "AR75_",
        "vaccinations": 1685793
      },
      {
        "ageType": "AR_UNDEFINED",
        "vaccinations": 5716
      },
      {
        "ageType": "AG_FEMALE",
        "vaccinations": 3241365
      },
      {
        "ageType": "AG_MALE",
        "vaccinations": 1646116
      },
      {
        "ageType": "AG_UNDEFINED",
        "vaccinations": 5839
      }
    ]
  },
  "today": {
    "vaccinations": 149828,
    "firstDoses": 85201,
    "secondDoses": 64627
  }
}
```

#### Raporty - województwo

```
GET https://koronawirus-api.koyeb.app/api/vaccinations/province
GET https://koronawirus-api.koyeb.app/api/vaccinations/province/małopolskie
```

```json
{
  "province": "małopolskie",
  "reportDate": "2021-02-09T22:32:28.364+0000",
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

#### Raporty - powiat

```
GET https://koronawirus-api.koyeb.app/api/vaccinations/district
GET https://koronawirus-api.koyeb.app/api/vaccinations/district/powiat tarnowski
```

```json
{
  "district": "powiat tarnowski",
  "reportDate": "2021-02-09T22:33:16.646+0000",
  "general": {
    "population": 201570,
    "vaccinations": 2512,
    "firstDoses": 2432,
    "secondDoses": 80
  },
  "today": {
    "vaccinations": 30,
    "firstDoses": 30,
    "secondDoses": 0
  }
}
```

#### ~~Raporty - punkty szczepień~~

```
GET https://koronawirus-api.koyeb.app/api/vaccinations/point
GET https://koronawirus-api.koyeb.app/api/vaccinations/point/ZESPÓŁ OPIEKI ZDROWOTNEJ W DĄBROWIE TARNOWSKIEJ
```

```json
{
  "name": "ZESPÓŁ OPIEKI ZDROWOTNEJ W DĄBROWIE TARNOWSKIEJ",
  "location": {
    "coordinates": {
      "x": 20.9926472694905,
      "y": 50.1772668373536
    },
    "address": "SZPITALNA 1",
    "city": "DĄBROWA TARNOWSKA"
  },
  "contact": {
    "phone": "14 64 43 282",
    "email": "bparka@zozdt.pl",
    "nfz": "06"
  },
  "general": {
    "vaccinations": 198
  },
  "today": {
    "vaccinations": 30
  }
}
```

#### Force Update

```
GET https://koronawirus-api.koyeb.app/forceUpdate
```
