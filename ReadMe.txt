Reads the twitter stream, pulls out the location from the tweet (not the geolocation)
and adds it as a header for another camel route (addweather2).

To build this project use

    mvn install

To run the project you can execute the following Maven goal

    mvn fabric8:deploy

