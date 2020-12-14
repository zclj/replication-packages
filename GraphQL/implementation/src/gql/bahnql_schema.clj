(ns gql.bahnql-schema)

(def schema-json
  "{
  \"data\": {
    \"__schema\": {
      \"queryType\": {
        \"name\": \"Query\"
      },
      \"mutationType\": null,
      \"subscriptionType\": null,
      \"types\": [
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Query\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"routing\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"from\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Int\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                },
                {
                  \"name\": \"to\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Int\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"Route\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"stationWithEvaId\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"evaId\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Int\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                }
              ],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Station\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"stationWithStationNumber\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"stationNumber\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Int\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                }
              ],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Station\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"stationWithRill100\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"rill100\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"String\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                }
              ],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Station\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"search\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"searchTerm\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"String\",
                    \"ofType\": null
                  },
                  \"defaultValue\": null
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Searchable\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"nearby\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"latitude\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Float\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                },
                {
                  \"name\": \"longitude\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Float\",
                      \"ofType\": null
                    }
                  },
                  \"defaultValue\": null
                },
                {
                  \"name\": \"radius\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"10000\"
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Nearby\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"parkingSpace\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"id\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": null
                }
              ],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"ParkingSpace\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"SCALAR\",
          \"name\": \"Int\",
          \"description\": \"The `Int` scalar type represents non-fractional signed whole numeric values. Int can represent values between -(2^31) and 2^31 - 1. \",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Route\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"parts\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"RoutePart\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"from\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Station\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"to\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Station\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"RoutePart\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"from\",
              \"description\": \"Station where the part begins\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Station\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"to\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Station\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"delay\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"product\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Product\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"direction\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"start\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"end\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"departingTrack\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Track\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"arrivingTrack\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Track\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Station\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"primaryEvaId\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"stationNumber\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"primaryRil100\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"location\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Location\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"category\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"priceCategory\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasParking\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasBicycleParking\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasLocalPublicTransport\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasPublicFacilities\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasLockerSystem\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasTaxiRank\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasTravelNecessities\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasSteplessAccess\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasMobilityService\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"federalState\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"regionalArea\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"RegionalArea\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"facilities\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"Facility\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"mailingAddress\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"MailingAddress\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"DBInformationOpeningTimes\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTimes\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"localServiceStaffAvailability\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTimes\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"aufgabentraeger\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"StationContact\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"timeTableOffice\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"StationContact\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"szentrale\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"StationContact\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"stationManagement\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"StationContact\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"timetable\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Timetable\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"parkingSpaces\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"ParkingSpace\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasSteamPermission\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasWiFi\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasTravelCenter\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasRailwayMission\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasDBLounge\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasLostAndFound\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasCarRental\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tracks\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"Track\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"picture\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Picture\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"SCALAR\",
          \"name\": \"String\",
          \"description\": \"The `String` scalar type represents textual data, represented as UTF-8 character sequences. The String type is most often used by GraphQL to represent free-form human-readable text.\",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Location\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"latitude\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Float\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"longitude\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Float\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"SCALAR\",
          \"name\": \"Float\",
          \"description\": \"The `Float` scalar type represents signed double-precision fractional values as specified by [IEEE 754](http://en.wikipedia.org/wiki/IEEE_floating_point). \",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"SCALAR\",
          \"name\": \"Boolean\",
          \"description\": \"The `Boolean` scalar type represents `true` or `false`.\",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"RegionalArea\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"number\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"shortName\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Facility\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"description\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"ENUM\",
                  \"name\": \"FacilityType\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"state\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"ENUM\",
                  \"name\": \"FacilityState\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"equipmentNumber\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"location\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Location\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"ENUM\",
          \"name\": \"FacilityType\",
          \"description\": \"\",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": [
            {
              \"name\": \"ESCALATOR\",
              \"description\": \"\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"ELEVATOR\",
              \"description\": \"\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"possibleTypes\": null
        },
        {
          \"kind\": \"ENUM\",
          \"name\": \"FacilityState\",
          \"description\": \"\",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": [
            {
              \"name\": \"ACTIVE\",
              \"description\": \"\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INACTIVE\",
              \"description\": \"\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"UNKNOWN\",
              \"description\": \"\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"MailingAddress\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"city\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"zipcode\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"street\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"OpeningTimes\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"monday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tuesday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"wednesday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"thursday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"friday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"saturday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"sunday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"holiday\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"OpeningTime\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"OpeningTime\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"from\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"to\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"StationContact\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"shortName\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"email\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"number\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"phoneNumber\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Timetable\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"nextArrivals\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"TrainInStation\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"nextDepatures\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"TrainInStation\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"TrainInStation\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"trainNumber\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"platform\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"time\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"stops\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"String\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"ParkingSpace\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"label\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"spaceNumber\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"responsibility\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"source\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"nameDisplay\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"spaceType\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"spaceTypeEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"spaceTypeName\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"location\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Location\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"operator\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"operatorUrl\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"address\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"MailingAddress\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"distance\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"facilityType\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"facilityTypeEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"openingHours\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"openingHoursEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"numberParkingPlaces\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"numberHandicapedPlaces\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isSpecialProductDb\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isOutOfService\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"station\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Station\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"occupancy\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Occupancy\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"outOfServiceText\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"outOfServiceTextEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"reservation\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"clearanceWidth\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"clearanceHeight\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"allowedPropulsions\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"hasChargingStation\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffPrices\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"ParkingPriceOption\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"outOfService\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isDiscountDbBahnCard\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isMonthVendingMachine\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isDiscountDbBahnComfort\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isDiscountDbParkAndRail\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isMonthParkAndRide\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isMonthSeason\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffDiscount\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffFreeParkingTime\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffDiscountEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffPaymentOptions\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffPaymentCustomerCards\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffFreeParkingTimeEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tariffPaymentOptionsEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"slogan\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"sloganEn\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Occupancy\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"validData\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"timestamp\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"timeSegment\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"category\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"text\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"ParkingPriceOption\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"duration\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"price\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Float\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Track\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"platform\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"number\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"length\",
              \"description\": \"Length of the platform in cm\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"height\",
              \"description\": \"Height of the platform in cm\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Picture\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"license\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"photographer\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Photographer\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Photographer\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Product\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"class\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"productCode\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"productName\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Searchable\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"stations\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"Station\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"operationLocations\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"OperationLocation\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"OperationLocation\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"abbrev\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"shortName\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"status\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"locationCode\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"UIC\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"regionId\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"validFrom\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"validTill\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"timeTableRelevant\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"borderStation\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"Nearby\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"stations\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"count\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"10\"
                },
                {
                  \"name\": \"offset\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"0\"
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"Station\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"parkingSpaces\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"count\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"10\"
                },
                {
                  \"name\": \"offset\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"0\"
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"ParkingSpace\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"travelCenters\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"count\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"10\"
                },
                {
                  \"name\": \"offset\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"0\"
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"TravelCenter\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"flinksterCars\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"count\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"10\"
                },
                {
                  \"name\": \"offset\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"0\"
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"FlinksterCar\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"bikes\",
              \"description\": \"\",
              \"args\": [
                {
                  \"name\": \"count\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"10\"
                },
                {
                  \"name\": \"offset\",
                  \"description\": \"\",
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Int\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"0\"
                }
              ],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"FlinksterBike\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"TravelCenter\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"address\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"MailingAddress\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"location\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"Location\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"FlinksterCar\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"attributes\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"CarAttributes\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"location\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Location\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"priceOptions\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"PriceOption\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"equipment\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"CarEquipment\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"rentalModel\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"parkingArea\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"FlinksterParkingArea\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"category\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"CarAttributes\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"seats\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"color\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"doors\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"transmissionType\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"licensePlate\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"fillLevel\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"fuel\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"PriceOption\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"interval\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Int\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"grossamount\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Float\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"currency\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"taxrate\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Float\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"preferredprice\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"CarEquipment\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"cdPlayer\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"airConditioning\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"navigationSystem\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"roofRailing\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"particulateFilter\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"audioInline\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"tyreType\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"bluetoothHandsFreeCalling\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"cruiseControl\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"passengerAirbagTurnOff\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isofixSeatFittings\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"Boolean\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"FlinksterParkingArea\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"address\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"MailingAddress\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"parkingDescription\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"accessDescription\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"locationDescription\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"publicTransport\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"provider\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"FlinksterProvider\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"position\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Location\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"GeoJSON\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"GeoJSON\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"FlinksterProvider\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"areaId\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"networkIds\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"SCALAR\",
                      \"name\": \"Int\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"GeoJSON\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"features\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"GeoFeature\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"GeoFeature\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"properties\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"GeoProperties\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"geometry\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"GeoPolygon\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"GeoProperties\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"GeoPolygon\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"coordinates\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"LIST\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"LIST\",
                      \"name\": null,
                      \"ofType\": {
                        \"kind\": \"LIST\",
                        \"name\": null,
                        \"ofType\": {
                          \"kind\": \"SCALAR\",
                          \"name\": \"Float\",
                          \"ofType\": null
                        }
                      }
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"FlinksterBike\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"id\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"url\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"location\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"Location\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"priceOptions\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"PriceOption\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"attributes\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"BikeAttributes\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"address\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"MailingAddress\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"rentalModel\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"providerRentalObjectId\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Int\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"parkingArea\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"FlinksterParkingArea\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"bookingUrl\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"BikeAttributes\",
          \"description\": \"\",
          \"fields\": [
            {
              \"name\": \"licensePlate\",
              \"description\": \"\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"__Schema\",
          \"description\": \"A GraphQL Schema defines the capabilities of a GraphQL server. It exposes all available types and directives on the server, as well as the entry points for query, mutation, and subscription operations.\",
          \"fields\": [
            {
              \"name\": \"types\",
              \"description\": \"A list of all types supported by this server.\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"__Type\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"queryType\",
              \"description\": \"The type that query operations will be rooted at.\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"__Type\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"mutationType\",
              \"description\": \"If this server supports mutation, the type that mutation operations will be rooted at.\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"__Type\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"subscriptionType\",
              \"description\": \"If this server support subscription, the type that subscription operations will be rooted at.\",
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"__Type\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"directives\",
              \"description\": \"A list of all directives supported by this server.\",
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"__Directive\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"__Type\",
          \"description\": \"The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in GraphQL as represented by the `__TypeKind` enum.\\n\\nDepending on the kind of a type, certain fields describe information about that type. Scalar types provide no information beyond a name and description, while Enum types provide their values. Object and Interface types provide the fields they describe. Abstract types, Union and Interface, provide the Object types possible at runtime. List and NonNull types compose other types.\",
          \"fields\": [
            {
              \"name\": \"kind\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"ENUM\",
                  \"name\": \"__TypeKind\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"name\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"fields\",
              \"description\": null,
              \"args\": [
                {
                  \"name\": \"includeDeprecated\",
                  \"description\": null,
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Boolean\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"false\"
                }
              ],
              \"type\": {
                \"kind\": \"LIST\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"NON_NULL\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"__Field\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"interfaces\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"LIST\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"NON_NULL\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"__Type\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"possibleTypes\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"LIST\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"NON_NULL\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"__Type\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"enumValues\",
              \"description\": null,
              \"args\": [
                {
                  \"name\": \"includeDeprecated\",
                  \"description\": null,
                  \"type\": {
                    \"kind\": \"SCALAR\",
                    \"name\": \"Boolean\",
                    \"ofType\": null
                  },
                  \"defaultValue\": \"false\"
                }
              ],
              \"type\": {
                \"kind\": \"LIST\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"NON_NULL\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"__EnumValue\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"inputFields\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"LIST\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"NON_NULL\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"OBJECT\",
                    \"name\": \"__InputValue\",
                    \"ofType\": null
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"ofType\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"OBJECT\",
                \"name\": \"__Type\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"ENUM\",
          \"name\": \"__TypeKind\",
          \"description\": \"An enum describing what kind of type a given `__Type` is.\",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": [
            {
              \"name\": \"SCALAR\",
              \"description\": \"Indicates this type is a scalar.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"OBJECT\",
              \"description\": \"Indicates this type is an object. `fields` and `interfaces` are valid fields.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INTERFACE\",
              \"description\": \"Indicates this type is an interface. `fields` and `possibleTypes` are valid fields.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"UNION\",
              \"description\": \"Indicates this type is a union. `possibleTypes` is a valid field.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"ENUM\",
              \"description\": \"Indicates this type is an enum. `enumValues` is a valid field.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INPUT_OBJECT\",
              \"description\": \"Indicates this type is an input object. `inputFields` is a valid field.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"LIST\",
              \"description\": \"Indicates this type is a list. `ofType` is a valid field.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"NON_NULL\",
              \"description\": \"Indicates this type is a non-null. `ofType` is a valid field.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"__Field\",
          \"description\": \"Object and Interface types are described by a list of Fields, each of which has a name, potentially a list of arguments, and a return type.\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"args\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"__InputValue\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"__Type\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isDeprecated\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"deprecationReason\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"__InputValue\",
          \"description\": \"Arguments provided to Fields or Directives and the input fields of an InputObject are represented as Input Values which describe their type and optionally a default value.\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"type\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"OBJECT\",
                  \"name\": \"__Type\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"defaultValue\",
              \"description\": \"A GraphQL-formatted string representing the default value for this input value.\",
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"__EnumValue\",
          \"description\": \"One possible value for a given Enum. Enum values are unique values, not a placeholder for a string or numeric value. However an Enum value is returned in a JSON response as a string.\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"isDeprecated\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"deprecationReason\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"OBJECT\",
          \"name\": \"__Directive\",
          \"description\": \"A Directive provides a way to describe alternate runtime execution and type validation behavior in a GraphQL document.\\n\\nIn some cases, you need to provide options to alter GraphQL's execution behavior in ways field arguments will not suffice, such as conditionally including or skipping a field. Directives provide this by describing additional information to the executor.\",
          \"fields\": [
            {
              \"name\": \"name\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"String\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"description\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"locations\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"ENUM\",
                      \"name\": \"__DirectiveLocation\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"args\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"LIST\",
                  \"name\": null,
                  \"ofType\": {
                    \"kind\": \"NON_NULL\",
                    \"name\": null,
                    \"ofType\": {
                      \"kind\": \"OBJECT\",
                      \"name\": \"__InputValue\",
                      \"ofType\": null
                    }
                  }
                }
              },
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"onOperation\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": true,
              \"deprecationReason\": \"Use `locations`.\"
            },
            {
              \"name\": \"onFragment\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": true,
              \"deprecationReason\": \"Use `locations`.\"
            },
            {
              \"name\": \"onField\",
              \"description\": null,
              \"args\": [],
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"isDeprecated\": true,
              \"deprecationReason\": \"Use `locations`.\"
            }
          ],
          \"inputFields\": null,
          \"interfaces\": [],
          \"enumValues\": null,
          \"possibleTypes\": null
        },
        {
          \"kind\": \"ENUM\",
          \"name\": \"__DirectiveLocation\",
          \"description\": \"A Directive can be adjacent to many parts of the GraphQL language, a __DirectiveLocation describes one such possible adjacencies.\",
          \"fields\": null,
          \"inputFields\": null,
          \"interfaces\": null,
          \"enumValues\": [
            {
              \"name\": \"QUERY\",
              \"description\": \"Location adjacent to a query operation.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"MUTATION\",
              \"description\": \"Location adjacent to a mutation operation.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"SUBSCRIPTION\",
              \"description\": \"Location adjacent to a subscription operation.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"FIELD\",
              \"description\": \"Location adjacent to a field.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"FRAGMENT_DEFINITION\",
              \"description\": \"Location adjacent to a fragment definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"FRAGMENT_SPREAD\",
              \"description\": \"Location adjacent to a fragment spread.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INLINE_FRAGMENT\",
              \"description\": \"Location adjacent to an inline fragment.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"SCHEMA\",
              \"description\": \"Location adjacent to a schema definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"SCALAR\",
              \"description\": \"Location adjacent to a scalar definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"OBJECT\",
              \"description\": \"Location adjacent to an object type definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"FIELD_DEFINITION\",
              \"description\": \"Location adjacent to a field definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"ARGUMENT_DEFINITION\",
              \"description\": \"Location adjacent to an argument definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INTERFACE\",
              \"description\": \"Location adjacent to an interface definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"UNION\",
              \"description\": \"Location adjacent to a union definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"ENUM\",
              \"description\": \"Location adjacent to an enum definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"ENUM_VALUE\",
              \"description\": \"Location adjacent to an enum value definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INPUT_OBJECT\",
              \"description\": \"Location adjacent to an input object type definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            },
            {
              \"name\": \"INPUT_FIELD_DEFINITION\",
              \"description\": \"Location adjacent to an input object field definition.\",
              \"isDeprecated\": false,
              \"deprecationReason\": null
            }
          ],
          \"possibleTypes\": null
        }
      ],
      \"directives\": [
        {
          \"name\": \"skip\",
          \"description\": \"Directs the executor to skip this field or fragment when the `if` argument is true.\",
          \"locations\": [
            \"FIELD\",
            \"FRAGMENT_SPREAD\",
            \"INLINE_FRAGMENT\"
          ],
          \"args\": [
            {
              \"name\": \"if\",
              \"description\": \"Skipped when true.\",
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"defaultValue\": null
            }
          ]
        },
        {
          \"name\": \"include\",
          \"description\": \"Directs the executor to include this field or fragment only when the `if` argument is true.\",
          \"locations\": [
            \"FIELD\",
            \"FRAGMENT_SPREAD\",
            \"INLINE_FRAGMENT\"
          ],
          \"args\": [
            {
              \"name\": \"if\",
              \"description\": \"Included when true.\",
              \"type\": {
                \"kind\": \"NON_NULL\",
                \"name\": null,
                \"ofType\": {
                  \"kind\": \"SCALAR\",
                  \"name\": \"Boolean\",
                  \"ofType\": null
                }
              },
              \"defaultValue\": null
            }
          ]
        },
        {
          \"name\": \"deprecated\",
          \"description\": \"Marks an element of a GraphQL schema as no longer supported.\",
          \"locations\": [
            \"FIELD_DEFINITION\",
            \"ENUM_VALUE\"
          ],
          \"args\": [
            {
              \"name\": \"reason\",
              \"description\": \"Explains why this element was deprecated, usually also including a suggestion for how to access supported similar data. Formatted in [Markdown](https://daringfireball.net/projects/markdown/).\",
              \"type\": {
                \"kind\": \"SCALAR\",
                \"name\": \"String\",
                \"ofType\": null
              },
              \"defaultValue\": \"\\\"No longer supported\\\"\"
            }
          ]
        }
      ]
    }
  }
}")
