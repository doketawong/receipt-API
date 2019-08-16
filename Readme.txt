
local build url: http://localhost:8080/getReceipt

Sample Post Request
{
    "itemDetails": [
        {
            "productName": "apple",
            "country": "ca",
            "price": 25.86,
            "quantity": 2
        },
                {
            "productName": "test",
            "country": "ny",
            "price": 100,
            "quantity": 2
        }
    ]
}

Sample Response:
{
    "itemDetailsWithTaxAndTotals": [
        {
            "productName": "apple",
            "country": "ca",
            "price": 25.86,
            "quantity": 2,
            "total": 51.75,
            "tax": 0.0
        },
        {
            "productName": "test",
            "country": "ny",
            "price": 100.0,
            "quantity": 2,
            "total": 200.0,
            "tax": 17.75
        }
    ],
    "subTotal": 251.75,
    "tax": 17.75,
    "error": null,
    "total": 269.5
}