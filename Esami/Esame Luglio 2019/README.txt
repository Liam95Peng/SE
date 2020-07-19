|||||||||||||||||||||||||||||N.B. BEFORE YOU START|||||||||||||||||||||||||||||

1) The client must implement the web service offered by the server!
	You just need to import in the project the WSDL offered.
	Click dx on th project -> add new -> web service client ->
						   -> WSDL url ->
						   -> "http:localhost:<port>/<service>?wsdl"

2) Producer needs activemq started to work
	Download on:
	https://activemq.apache.org/getting-started#StartingActiveMQStartingActiveMQ
	I've saved activemq on "/<user>/Dependencies"
	cd /<user>/Dependencies/apache-activemq.../bin
	./activemq start
	
||||||||||||||||||||||||||||||||||||SERVER|||||||||||||||||||||||||||||||||||||

1) Class Server
	-> Make an istance of ServiceImpl "implementor"
	-> Set an address entrypoint 
	-> Publish on endpoint (address, implementor)

2) Class MovieDetail	
	Generic class, just remember the @XmlRootElement(name = "MovieDetail").
	
3) Service
	3.1) Implementation
		In the constructor setup the coonection to the DB
		(Specified at DriverManager.getConnection(...))
		Remember as usual the
		@WebService(endpointInterface = "com.mycompany.giugno2019_server_01.Service")
		Provide the getMoviesList method, be carefull to not use map<Integer, whatever>
		becouse map is a complex method (you'll need a correct marshaling).
		I suggest you to use an ArrayList.

		N.B.
		jdbc:sqlite:<path_to_db> => if not specified but only named the .db file
		will be created in the current dir.

	3.2) Interface
		Just remember the 
		@WebService

Check if http://localhost:<port>/<service>:wsdl return the correct xml, otherwise ammazzate.
	 
||||||||||||||||||||||||||||||||||||DBATABASE||||||||||||||||||||||||||||||||||||

1) Class Database
	Setup DB connection and provide create and inster query.
	Remember the "Class.forName("org.sqlite.JDBC");"

	
||||||||||||||||||||||||||||||||||||||CLIENT|||||||||||||||||||||||||||||||||||||

1) Class Client
	Import and instantiate the service provided by the server.
	Use the method through port and simply print the result.
	
