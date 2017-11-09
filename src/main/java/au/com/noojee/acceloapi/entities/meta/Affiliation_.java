package au.com.noojee.acceloapi.entities.meta;

/** 
 *
 *          DO NOT MODIFY 
 *
 * This code is generated by au.com.noojee.acceloapi.entities.meta.FieldMetaDataGenerator
 *
 * The generator use @AcceloField annotations to determine what fields to include in the Meta data.
 *
 *          DO NOT MODIFY 
 *
 */
import java.time.LocalDate;

import au.com.noojee.acceloapi.entities.Affiliation;
import au.com.noojee.acceloapi.entities.generator.FilterField;


public class Affiliation_ 
{

	public static FilterField<Affiliation, Integer> company = new FilterField<>("company"); 
	public static FilterField<Affiliation, Integer> contact = new FilterField<>("contact"); 
	public static FilterField<Affiliation, String> contact_number = new FilterField<>("contact_number"); 
	public static FilterField<Affiliation, LocalDate> date_modified = new FilterField<>("date_modified"); 
	public static FilterField<Affiliation, Integer> id = new FilterField<>("id"); 
	public static FilterField<Affiliation, Integer> physical_address = new FilterField<>("physical_address"); 
	public static FilterField<Affiliation, Integer> postal_address = new FilterField<>("postal_address"); 
	public static FilterField<Affiliation, String> standing = new FilterField<>("standing"); 
	public static FilterField<Affiliation, String> status = new FilterField<>("status"); 

}
