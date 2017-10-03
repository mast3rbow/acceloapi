package au.com.noojee.acceloapi.entities;

import java.time.LocalDate;

import au.com.noojee.acceloapi.AcceloApi;

public class ContractPeriod extends AcceloEntity<ContractPeriod>
{
	int id;
	int contract_id;
	long date_created;
	long date_commenced;
	long date_closed;
	long date_expires;

	String budget_type; // pre-paid
	String duration_type; // fixed
	float contract_budget;
	String rollover; // yes no
	String standing; // open
	String contract;
	int rate_id; // -1
	String rate_type; // object
	String allowance_type; // fixed_value
	int service_item_id;

	public int getId()
	{
		return id;
	}

	public LocalDate getDateCommenced()
	{
		return AcceloApi.toLocalDate(date_commenced);
	}

	public LocalDate getDateExpires()
	{
		return AcceloApi.toLocalDate(date_expires);
	}

	public double getBudget()
	{
		return this.contract_budget;
	}

	@Override
	public String toString()
	{
		return "Contract_period [id=" + id + ", contract_id=" + contract_id + ", date_created=" + date_created
				+ ", date_commenced=" + date_commenced + ", date_closed=" + date_closed + ", date_expires="
				+ date_expires + ", budget_type=" + budget_type + ", duration_type=" + duration_type
				+ ", contract_budget=" + contract_budget + ", rollover=" + rollover + ", standing=" + standing
				+ ", contract=" + contract + ", rate_id=" + rate_id + ", rate_type=" + rate_type + ", allowance_type="
				+ allowance_type + ", service_item_id=" + service_item_id + "]";
	}

}