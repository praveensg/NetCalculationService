# Net Amount Calculation Service

Spring Boot Rest application which calculates the net amount from the given Gross amount and country information.

## API example:

```
`/calculateNetPrice?grossPrice=10000&countryIso=DE`
```

## Assumptions

- TaxRate is added within service as a Map and added below values in the map.

| Country           | TaxRate          |
| ----------------- | ---------------- |
| DE                | 0.19             |
| FR                | 0.20             |
| US                | 0.30             |
| SW                | 0.25             |
| IN                | 0.15             |
