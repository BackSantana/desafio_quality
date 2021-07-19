# Desafio Quality

### Rota: `post -> /api/district/add`
 #### Payload
    {
        "districtName": "Bela Vista",
        "valueDistrictM2": 4000 
    }
#### Response
    Status.code: 201
    Headers: http://localhost:8080/api/district/add/1

### Rota: `post -> /api/property/add`
 #### Payload
    {
        "homeName": "Casa do Carlos",
        "discrictId": 1,
        "roomList":
        [
            {"roomName": "Quarto", "roomWidth": 10, "roomLength": 32 },
            {"roomName": "Sala", "roomWidth": 23, "roomLength": 25 },
            {"roomName": "Presunto", "roomWidth": 23, "roomLength": 33 }
        ]
    }
#### Response 
    Status.code: 201
    Headers: http://localhost:8080/api/property/add/{1

### Rota: `get -> /api/property/get/{propertyId}`
 #### Response
    Status.code: 200
        {
            "id": 1,
            "nome": "Casa do Carlos",
        "district": {
            "id": 1,
            "districtName": "Bela Vista",
            "valueDistrictM2": 4000.00
        },
        "roomLists": [
            {
                "id": 1,
                "roomName": "Quarto",
                "roomWidth": 10.0,
                "roomLength": 32.0,
                "squareMeter": 320.0
            },
            {
                "id": 2,
                "roomName": "Sala",
                "roomWidth": 23.0,
                "roomLength": 25.0,
                "squareMeter": 575.0
            },
            {
                "id": 3,
                "roomName": "Presunto",
                "roomWidth": 23.0,
                "roomLength": 33.0,
                "squareMeter": 759.0
            }
        ]
    }

### Rota: `get -> /api/property/calculateM2/{propertyId}`
#### Response:
        {
        "id": 1,
        "nome": "Casa do Carlos",
        "district": {
            "districtName": "Bela Vista",
            "valueDistrictM2": 4000.00
        },
        "roomLists": [
           {
                "roomName": "Quarto",
                "roomWidth": 10.0,
                "roomLength": 32.0,
                "squareMeter": 320.0
            },
            {
                "roomName": "Sala",
                "roomWidth": 23.0,
                "roomLength": 25.0,
                "squareMeter": 575.0
            },
            {
                "roomName": "Presunto",
                "roomWidth": 23.0,
                "roomLength": 33.0,
                "squareMeter": 759.0
            }
        ],
        "propertyCalculations": {
            "totalM2": 1654.0
        }
    }

### Rota: `get -> /api/property/calculateValue/{propertyId}`
#### Response
    {
        "id": 1,
        "nome": "Casa do Carlos",
        "district": {
            "districtName": "Bela Vista",
            "valueDistrictM2": 4000.00
        },
        "roomLists": [
        {
            "roomName": "Quarto",
            "roomWidth": 10.0,
            "roomLength": 32.0,
            "squareMeter": 320.0
        },
        {
            "roomName": "Sala",
            "roomWidth": 23.0,
            "roomLength": 25.0,
            "squareMeter": 575.0
        },
        {
            "roomName": "Presunto",
            "roomWidth": 23.0,
            "roomLength": 33.0,
            "squareMeter": 759.0
        }
        ],
        "propertyCalculations": {
            "value_property_m2": 6616000.000
        }
    }

### Rota: `get -> /api/property/calculateAll/{propertyId}`
#### Response
    {
        "id": 1,
        "nome": "Casa do Carlos",
        "district": {
            "districtName": "Bela Vista",
            "valueDistrictM2": 4000.00
        },
        "roomLists": [
        {
            "roomName": "Quarto",
            "roomWidth": 10.0,
            "roomLength": 32.0,
            "squareMeter": 320.0
        },
        {
            "roomName": "Sala",
            "roomWidth": 23.0,
            "roomLength": 25.0,
            "squareMeter": 575.0
        },
        {
            "roomName": "Presunto",
            "roomWidth": 23.0,
            "roomLength": 33.0,
            "squareMeter": 759.0
        }
        ],
        "propertyCalculations": {
            "totalM2": 1654.0,
            "value_property_m2": 6616000.000,
            "biggestRoom": {
                "roomName": "Presunto",
                "roomWidth": 23.0,
                "roomLength": 33.0,
                "squareMeter": 759.0
            }
        }
    }
### Rota: `get -> /api/room/biggest/{propertyId}`
#### Response
    {
        "id": 1,
        "nome": "Casa do Carlos",
        "district": {
            "districtName": "Bela Vista",
            "valueDistrictM2": 4000.00
        },
        "roomLists": [
        {
            "roomName": "Quarto",
            "roomWidth": 10.0,
            "roomLength": 32.0,
            "squareMeter": 320.0
        },
        {
            "roomName": "Sala",
            "roomWidth": 23.0,
            "roomLength": 25.0,
            "squareMeter": 575.0
        },
        {
            "roomName": "Presunto",
            "roomWidth": 23.0,
            "roomLength": 33.0,
            "squareMeter": 759.0
        }
        ],
        "propertyCalculations": {
            "biggestRoom": {
                "roomName": "Presunto",
                "roomWidth": 23.0,
                "roomLength": 33.0,
                "squareMeter": 759.0
            }
        }
    }
### Rota: `get -> /api/room/findAll/{propertyId}`
#### Response
    {
        "id": 1,
        "nome": "Casa do Carlos",
        "district": {
            "districtName": "Bela Vista",
            "valueDistrictM2": 4000.00
        },
        "roomLists": [
        {
            "roomName": "Quarto",
            "roomWidth": 10.0,
            "roomLength": 32.0,
            "squareMeter": 320.0
        },
        {
            "roomName": "Sala",
            "roomWidth": 23.0,
            "roomLength": 25.0,
            "squareMeter": 575.0
        },
        {
            "roomName": "Presunto",
            "roomWidth": 23.0,
            "roomLength": 33.0,
            "squareMeter": 759.0
        }
        ],
    }
    OBS: Retorna todas as rooms com o M2 calculado.
