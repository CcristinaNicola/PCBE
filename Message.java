import java.util.Date;

public class Message {
    private String domain;
    private String subdomain;
    private String source;
    private String author;
    private String payload;

	private String newText;

	private Date publicationDate;
	private Date modifiedDate;

    public Message(String domain, String subdomain, String source, String author, String payload) 
    {
        this.domain = domain;
        this.subdomain = subdomain;
        this.source = source;
        this.author = author;
        this.payload = payload;
    }

    public void setPublicationDate(Date publicationDate)
	{
		this.publicationDate = publicationDate;
	}

	public void setModifiedDate(Date modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public Message(String newText)
	{
		this.newText = newText;
	}

	public String getUpdatedText()
	{
		return newText;
	}

    public void modifyText(String newText)
	{
		this.payload = newText;
	}
    
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSubdomain() {
		return subdomain;
	}
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
    
    
}