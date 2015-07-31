# java-yelp-dataset-formatting
In this project, i processed yelp json data which was not in correct format for data processing using R. That's why this program converts all JSON files to CSV.


All yelp dataset files are in JSON format. If you want to read all these files programmatically then it wont be possible because its not in correct format as expected.
All files contains data in below format,

JSON object 1
JSON object 2
.
.
.
JSON object n and so on

It should be in below format,

JSON object 1,
JSON object 2,
.            ,
.            ,
.            ,
JSON object n

Now thats why i converted all the JSON files to csv instead of correcting the JSON file.

You can access yelp dataset - here
http://www.yelp.com/dataset_challenge
