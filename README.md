# -Android-FreeNow-Coding-Challange

# To Run this App you need google Map Key

Android Candidate Test (Applicant Coding Challenge)

Task 1: Loading data and displaying it
Write an app containing a list. The list should show all the vehicle data in the bounds of Hamburg (53.694865,
9.757589 & 53.394655, 10.099891).
Use this endpoint to get the vehicles: https://fake-poi-api.mytaxi.com/?p1Lat={Latitude1}&p1Lon={Longitude1}&p2Lat={Latitude2}&p2Lon={Longit
ude2}

Example of a response:
{
"poiList": [{
"id": 439670,
"coordinate": {
"latitude": 53.46036882190762,
"longitude": 9.909716434648558
},
"fleetType": "POOLING",
"heading": 344.19529122029735
},
{
"id": 739330,
"coordinate": {
"latitude": 53.668806556867445,
"longitude": 10.019908942943804
},
"fleetType": "TAXI",
"heading": 245.2005654202569
},
{
"id": 145228,
"coordinate": {
"latitude": 53.58500747958201,
"longitude": 9.807045083858156
},
"fleetType": "POOLING",
"heading": 71.63840043828377
}
]
}
Fill the list items with some useful vehicle-information provided by the JSON response. You can create custom list items with selected vehicle
data - simply impress us
Make the app look neat and structure the code appropriately.
Hint: You are encouraged to use libraries if you consider them useful. Please document the sources of code you did not write yourself (if they are
not listed in the gradle dependencies).

Task 2: Google Maps showing the vehicles
Implement a map Activity/Fragment with Google Maps. Show all available vehicles on the map. Use the bounds of the map to request the
vehicles.
The map should zoom and center on a specific vehicle when it is selected in the previously implemented list.

Additional requirements
Please attach a working .apk when submitting your code.
Don't use any Android Studio preview or beta version when creating your test. Please use the stable version only.
Please name your zip-file with your full name
