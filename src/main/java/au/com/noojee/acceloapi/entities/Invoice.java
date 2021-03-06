package au.com.noojee.acceloapi.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import au.com.noojee.acceloapi.entities.meta.fieldTypes.BasicFilterField;
import au.com.noojee.acceloapi.entities.meta.fieldTypes.DateFilterField;
import au.com.noojee.acceloapi.entities.types.AgainstType;

public class Invoice extends AcceloEntity<Invoice>
{
	private float amount; // The value of the invoice, less any tax.
	private String subject; // The title of the invoice
	private AgainstType against_type; // The object the invoice was created against (usually the company)
	private int against_id; // The unique identifier for the object the invoice was created against (i.e the company
							// id).
	private String notes; // notes made on the invoice.

	/**
	 * If the invoice has been pushed to an accounting system (e.g. Xero, Quickbooks Online, Saasu, etc.), then this
	 * will be the invoice number generated by this system.
	 */
	@BasicFilterField
	private int invoice_number;
	private int currency_id;// unsigned The unique identifier for the currency used on the invoice.
	private int owner_id; // unsigned The unique identifier for the staff member labeled as the owner on the deployment.
	private float tax; // The value of any tax on the invoice.
	private float outstanding; // decimal The value of the invoice left unpaid, including taxes.
	private int modified_by; // unsigned The unique identifier of the staff member who

	@DateFilterField
	private LocalDate date_raised ; // unix ts The date the invoice was raised.
	@DateFilterField
	private LocalDate date_due ; // unix ts The date the invoice is due.
	@DateFilterField
	private LocalDateTime date_modified; // unix ts The date the invoice was last modified.
	private int contact; // The id of the contact to whom the invoice is to be billed.
	private int affiliation_id; // unsigned The unique identifier for the affiliation the invoice is raised against.
	private int affiliation; // unsigned or object The affiliation against whom the invoice is raised.
	private int creator_id; // unsigned The unique identifier for the staff member who created the deployment.
	private int created_by; // unsigned or object The staff member who created the invoice.

	public float getAmount()
	{
		return amount;
	}

	public String getSubject()
	{
		return subject;
	}

	public AgainstType getAgainstType()
	{
		return against_type;
	}

	public int getAgainstId()
	{
		return against_id;
	}

	public String getNotes()
	{
		return notes;
	}

	public int getInvoice_number()
	{
		return invoice_number;
	}

	public int getCurrencyId()
	{
		return currency_id;
	}

	public int getOwnerId()
	{
		return owner_id;
	}

	public float getTax()
	{
		return tax;
	}

	public float getOutstanding()
	{
		return outstanding;
	}

	public int getModifiedBy()
	{
		return modified_by;
	}

	public LocalDate getDateRaised()
	{
		return date_raised;
	}

	public LocalDate getDateDue()
	{
		return date_due;
	}

	public LocalDateTime getDateTimeModified()
	{
		return date_modified;
	}

	public int getContact()
	{
		return contact;
	}

	public int getAffiliationId()
	{
		return affiliation_id;
	}

	public int getAffiliation()
	{
		return affiliation;
	}

	public int getCreatorId()
	{
		return creator_id;
	}

	public int getCreatedBy()
	{
		return created_by;
	}

	@Override
	public String toString()
	{
		return "Invoice [id=" + getId() + ", amount=" + amount + ", subject=" + subject + ", against_type="
				+ against_type + ", against_id=" + against_id + ", notes=" + notes + ", invoice_number="
				+ invoice_number + ", currency_id=" + currency_id + ", owner_id=" + owner_id + ", tax=" + tax
				+ ", outstanding=" + outstanding + ", modified_by=" + modified_by + ", date_raised="
				+ date_raised + ", date_due=" + date_due + ", date_modified=" + date_modified + ", contact=" + contact
				+ ", affiliation_id=" + affiliation_id + ", affiliation=" + affiliation
				+ ", creator_id=" + creator_id + ", created_by=" + created_by + "]";
	}

}
