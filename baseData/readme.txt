This is an array of JSON Objects. Each Object is a Department. Each Department has a "dept" field (cecs, engl, engr)
Here is a sample Department Object :
{
	"dept" : "CECS"
	"courses" : {
		{"num": "100"}, ----> This is the class for example CECS 100, there maybe duplicates for multiple sections
		{...},
		{...}
	}
} 
All other data is not relevant for our use case.

You can put the file in in assets and the open it as a json object

usefull links: 

https://stackoverflow.com/questions/19945411/android-java-how-can-i-parse-a-local-json-file-from-assets-folder-into-a-listvi
https://stackoverflow.com/questions/13573913/android-jsonobject-how-can-i-loop-through-a-flat-json-object-to-get-each-key-a
there also is a json object page in the dev docs


