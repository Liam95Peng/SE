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
	-> Make some test professors (can be changed with a better persistance layer)
	-> Make an istance of ServiceImpl "implementor"
	-> Set an address entrypoint 
	-> Publish on endpoint (address, implementor

2) Class Professor	
	Generic professor class, just remember the @XmlRootElement(name = "Professor").
	
3) Service
	3.1) Implementation
		Just provide getDetails function, remember to set
		@WebService(endpointInterface = "com.mycompany.giugno2019_server_01.Service")

	3.2) Interface
		Just remember the 
		@WebService

Check if http://localhost:<port>/<service>:wsdl return the correct xml, otherwise ammazzate.
	 
||||||||||||||||||||||||||||||||||||PRODUCER||||||||||||||||||||||||||||||||||||

1) Class Server
	Just start the producer, instance a new Producer and then .start().
	Try catch always be with you.

2) Class Producer
	Implement JMS logic as usual (bigliettozzo pefforza)
	Deveolop an endless loop to produce the required msg (Id + Rank)
	That will be consumed by the client.

	N.B. 
	Be carefull with topic name for the next step!!	
	
||||||||||||||||||||||||||||||||||||||CLIENT|||||||||||||||||||||||||||||||||||||

1) Launcher
	Simply launch ClientListner

2) ClientListener
	2.1) Implements MessageListener so all the required methods
	2.2) Pull the values from the topic (onMessage) and call the method exposed on wsdl
		in this case getDetails(id)
	
