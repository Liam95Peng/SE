
package com.mycompany.luglio2019_server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.luglio2019_server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MovieDetail_QNAME = new QName("http://luglio2019_server.mycompany.com/", "MovieDetail");
    private final static QName _GetMoiviesList_QNAME = new QName("http://luglio2019_server.mycompany.com/", "getMoiviesList");
    private final static QName _GetMoiviesListResponse_QNAME = new QName("http://luglio2019_server.mycompany.com/", "getMoiviesListResponse");
    private final static QName _SQLException_QNAME = new QName("http://luglio2019_server.mycompany.com/", "SQLException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.luglio2019_server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link GetMoiviesListResponse }
     * 
     */
    public GetMoiviesListResponse createGetMoiviesListResponse() {
        return new GetMoiviesListResponse();
    }

    /**
     * Create an instance of {@link GetMoiviesList }
     * 
     */
    public GetMoiviesList createGetMoiviesList() {
        return new GetMoiviesList();
    }

    /**
     * Create an instance of {@link MovieDetail }
     * 
     */
    public MovieDetail createMovieDetail() {
        return new MovieDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovieDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2019_server.mycompany.com/", name = "MovieDetail")
    public JAXBElement<MovieDetail> createMovieDetail(MovieDetail value) {
        return new JAXBElement<MovieDetail>(_MovieDetail_QNAME, MovieDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoiviesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2019_server.mycompany.com/", name = "getMoiviesList")
    public JAXBElement<GetMoiviesList> createGetMoiviesList(GetMoiviesList value) {
        return new JAXBElement<GetMoiviesList>(_GetMoiviesList_QNAME, GetMoiviesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoiviesListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2019_server.mycompany.com/", name = "getMoiviesListResponse")
    public JAXBElement<GetMoiviesListResponse> createGetMoiviesListResponse(GetMoiviesListResponse value) {
        return new JAXBElement<GetMoiviesListResponse>(_GetMoiviesListResponse_QNAME, GetMoiviesListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2019_server.mycompany.com/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

}
