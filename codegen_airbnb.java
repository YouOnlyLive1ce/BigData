// ORM class for table 'airbnb'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sat Apr 05 13:13:58 MSK 2025
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class codegen_airbnb extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.id = (Integer)value;
      }
    });
    setters.put("name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.name = (String)value;
      }
    });
    setters.put("neighborhood_overview", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.neighborhood_overview = (String)value;
      }
    });
    setters.put("transit", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.transit = (String)value;
      }
    });
    setters.put("neighbourhood", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.neighbourhood = (String)value;
      }
    });
    setters.put("city", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.city = (String)value;
      }
    });
    setters.put("state", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.state = (String)value;
      }
    });
    setters.put("country", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.country = (String)value;
      }
    });
    setters.put("zipcode", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.zipcode = (String)value;
      }
    });
    setters.put("summary", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.summary = (String)value;
      }
    });
    setters.put("property_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.property_type = (String)value;
      }
    });
    setters.put("room_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.room_type = (String)value;
      }
    });
    setters.put("accommodates", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.accommodates = (Double)value;
      }
    });
    setters.put("bathrooms", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.bathrooms = (Double)value;
      }
    });
    setters.put("bedrooms", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.bedrooms = (Double)value;
      }
    });
    setters.put("beds", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.beds = (Double)value;
      }
    });
    setters.put("bed_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.bed_type = (String)value;
      }
    });
    setters.put("square_feet", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.square_feet = (Double)value;
      }
    });
    setters.put("price", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.price = (Double)value;
      }
    });
    setters.put("number_of_reviews", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.number_of_reviews = (Double)value;
      }
    });
    setters.put("review_scores_rating", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.review_scores_rating = (Double)value;
      }
    });
    setters.put("review_scores_cleanliness", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.review_scores_cleanliness = (Double)value;
      }
    });
    setters.put("review_scores_location", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.review_scores_location = (Double)value;
      }
    });
    setters.put("latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.latitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_airbnb.this.longitude = (java.math.BigDecimal)value;
      }
    });
  }
  public codegen_airbnb() {
    init0();
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public codegen_airbnb with_id(Integer id) {
    this.id = id;
    return this;
  }
  private String name;
  public String get_name() {
    return name;
  }
  public void set_name(String name) {
    this.name = name;
  }
  public codegen_airbnb with_name(String name) {
    this.name = name;
    return this;
  }
  private String neighborhood_overview;
  public String get_neighborhood_overview() {
    return neighborhood_overview;
  }
  public void set_neighborhood_overview(String neighborhood_overview) {
    this.neighborhood_overview = neighborhood_overview;
  }
  public codegen_airbnb with_neighborhood_overview(String neighborhood_overview) {
    this.neighborhood_overview = neighborhood_overview;
    return this;
  }
  private String transit;
  public String get_transit() {
    return transit;
  }
  public void set_transit(String transit) {
    this.transit = transit;
  }
  public codegen_airbnb with_transit(String transit) {
    this.transit = transit;
    return this;
  }
  private String neighbourhood;
  public String get_neighbourhood() {
    return neighbourhood;
  }
  public void set_neighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }
  public codegen_airbnb with_neighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
    return this;
  }
  private String city;
  public String get_city() {
    return city;
  }
  public void set_city(String city) {
    this.city = city;
  }
  public codegen_airbnb with_city(String city) {
    this.city = city;
    return this;
  }
  private String state;
  public String get_state() {
    return state;
  }
  public void set_state(String state) {
    this.state = state;
  }
  public codegen_airbnb with_state(String state) {
    this.state = state;
    return this;
  }
  private String country;
  public String get_country() {
    return country;
  }
  public void set_country(String country) {
    this.country = country;
  }
  public codegen_airbnb with_country(String country) {
    this.country = country;
    return this;
  }
  private String zipcode;
  public String get_zipcode() {
    return zipcode;
  }
  public void set_zipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public codegen_airbnb with_zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }
  private String summary;
  public String get_summary() {
    return summary;
  }
  public void set_summary(String summary) {
    this.summary = summary;
  }
  public codegen_airbnb with_summary(String summary) {
    this.summary = summary;
    return this;
  }
  private String property_type;
  public String get_property_type() {
    return property_type;
  }
  public void set_property_type(String property_type) {
    this.property_type = property_type;
  }
  public codegen_airbnb with_property_type(String property_type) {
    this.property_type = property_type;
    return this;
  }
  private String room_type;
  public String get_room_type() {
    return room_type;
  }
  public void set_room_type(String room_type) {
    this.room_type = room_type;
  }
  public codegen_airbnb with_room_type(String room_type) {
    this.room_type = room_type;
    return this;
  }
  private Double accommodates;
  public Double get_accommodates() {
    return accommodates;
  }
  public void set_accommodates(Double accommodates) {
    this.accommodates = accommodates;
  }
  public codegen_airbnb with_accommodates(Double accommodates) {
    this.accommodates = accommodates;
    return this;
  }
  private Double bathrooms;
  public Double get_bathrooms() {
    return bathrooms;
  }
  public void set_bathrooms(Double bathrooms) {
    this.bathrooms = bathrooms;
  }
  public codegen_airbnb with_bathrooms(Double bathrooms) {
    this.bathrooms = bathrooms;
    return this;
  }
  private Double bedrooms;
  public Double get_bedrooms() {
    return bedrooms;
  }
  public void set_bedrooms(Double bedrooms) {
    this.bedrooms = bedrooms;
  }
  public codegen_airbnb with_bedrooms(Double bedrooms) {
    this.bedrooms = bedrooms;
    return this;
  }
  private Double beds;
  public Double get_beds() {
    return beds;
  }
  public void set_beds(Double beds) {
    this.beds = beds;
  }
  public codegen_airbnb with_beds(Double beds) {
    this.beds = beds;
    return this;
  }
  private String bed_type;
  public String get_bed_type() {
    return bed_type;
  }
  public void set_bed_type(String bed_type) {
    this.bed_type = bed_type;
  }
  public codegen_airbnb with_bed_type(String bed_type) {
    this.bed_type = bed_type;
    return this;
  }
  private Double square_feet;
  public Double get_square_feet() {
    return square_feet;
  }
  public void set_square_feet(Double square_feet) {
    this.square_feet = square_feet;
  }
  public codegen_airbnb with_square_feet(Double square_feet) {
    this.square_feet = square_feet;
    return this;
  }
  private Double price;
  public Double get_price() {
    return price;
  }
  public void set_price(Double price) {
    this.price = price;
  }
  public codegen_airbnb with_price(Double price) {
    this.price = price;
    return this;
  }
  private Double number_of_reviews;
  public Double get_number_of_reviews() {
    return number_of_reviews;
  }
  public void set_number_of_reviews(Double number_of_reviews) {
    this.number_of_reviews = number_of_reviews;
  }
  public codegen_airbnb with_number_of_reviews(Double number_of_reviews) {
    this.number_of_reviews = number_of_reviews;
    return this;
  }
  private Double review_scores_rating;
  public Double get_review_scores_rating() {
    return review_scores_rating;
  }
  public void set_review_scores_rating(Double review_scores_rating) {
    this.review_scores_rating = review_scores_rating;
  }
  public codegen_airbnb with_review_scores_rating(Double review_scores_rating) {
    this.review_scores_rating = review_scores_rating;
    return this;
  }
  private Double review_scores_cleanliness;
  public Double get_review_scores_cleanliness() {
    return review_scores_cleanliness;
  }
  public void set_review_scores_cleanliness(Double review_scores_cleanliness) {
    this.review_scores_cleanliness = review_scores_cleanliness;
  }
  public codegen_airbnb with_review_scores_cleanliness(Double review_scores_cleanliness) {
    this.review_scores_cleanliness = review_scores_cleanliness;
    return this;
  }
  private Double review_scores_location;
  public Double get_review_scores_location() {
    return review_scores_location;
  }
  public void set_review_scores_location(Double review_scores_location) {
    this.review_scores_location = review_scores_location;
  }
  public codegen_airbnb with_review_scores_location(Double review_scores_location) {
    this.review_scores_location = review_scores_location;
    return this;
  }
  private java.math.BigDecimal latitude;
  public java.math.BigDecimal get_latitude() {
    return latitude;
  }
  public void set_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
  }
  public codegen_airbnb with_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }
  private java.math.BigDecimal longitude;
  public java.math.BigDecimal get_longitude() {
    return longitude;
  }
  public void set_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
  }
  public codegen_airbnb with_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof codegen_airbnb)) {
      return false;
    }
    codegen_airbnb that = (codegen_airbnb) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.name == null ? that.name == null : this.name.equals(that.name));
    equal = equal && (this.neighborhood_overview == null ? that.neighborhood_overview == null : this.neighborhood_overview.equals(that.neighborhood_overview));
    equal = equal && (this.transit == null ? that.transit == null : this.transit.equals(that.transit));
    equal = equal && (this.neighbourhood == null ? that.neighbourhood == null : this.neighbourhood.equals(that.neighbourhood));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.country == null ? that.country == null : this.country.equals(that.country));
    equal = equal && (this.zipcode == null ? that.zipcode == null : this.zipcode.equals(that.zipcode));
    equal = equal && (this.summary == null ? that.summary == null : this.summary.equals(that.summary));
    equal = equal && (this.property_type == null ? that.property_type == null : this.property_type.equals(that.property_type));
    equal = equal && (this.room_type == null ? that.room_type == null : this.room_type.equals(that.room_type));
    equal = equal && (this.accommodates == null ? that.accommodates == null : this.accommodates.equals(that.accommodates));
    equal = equal && (this.bathrooms == null ? that.bathrooms == null : this.bathrooms.equals(that.bathrooms));
    equal = equal && (this.bedrooms == null ? that.bedrooms == null : this.bedrooms.equals(that.bedrooms));
    equal = equal && (this.beds == null ? that.beds == null : this.beds.equals(that.beds));
    equal = equal && (this.bed_type == null ? that.bed_type == null : this.bed_type.equals(that.bed_type));
    equal = equal && (this.square_feet == null ? that.square_feet == null : this.square_feet.equals(that.square_feet));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.number_of_reviews == null ? that.number_of_reviews == null : this.number_of_reviews.equals(that.number_of_reviews));
    equal = equal && (this.review_scores_rating == null ? that.review_scores_rating == null : this.review_scores_rating.equals(that.review_scores_rating));
    equal = equal && (this.review_scores_cleanliness == null ? that.review_scores_cleanliness == null : this.review_scores_cleanliness.equals(that.review_scores_cleanliness));
    equal = equal && (this.review_scores_location == null ? that.review_scores_location == null : this.review_scores_location.equals(that.review_scores_location));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof codegen_airbnb)) {
      return false;
    }
    codegen_airbnb that = (codegen_airbnb) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.name == null ? that.name == null : this.name.equals(that.name));
    equal = equal && (this.neighborhood_overview == null ? that.neighborhood_overview == null : this.neighborhood_overview.equals(that.neighborhood_overview));
    equal = equal && (this.transit == null ? that.transit == null : this.transit.equals(that.transit));
    equal = equal && (this.neighbourhood == null ? that.neighbourhood == null : this.neighbourhood.equals(that.neighbourhood));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.country == null ? that.country == null : this.country.equals(that.country));
    equal = equal && (this.zipcode == null ? that.zipcode == null : this.zipcode.equals(that.zipcode));
    equal = equal && (this.summary == null ? that.summary == null : this.summary.equals(that.summary));
    equal = equal && (this.property_type == null ? that.property_type == null : this.property_type.equals(that.property_type));
    equal = equal && (this.room_type == null ? that.room_type == null : this.room_type.equals(that.room_type));
    equal = equal && (this.accommodates == null ? that.accommodates == null : this.accommodates.equals(that.accommodates));
    equal = equal && (this.bathrooms == null ? that.bathrooms == null : this.bathrooms.equals(that.bathrooms));
    equal = equal && (this.bedrooms == null ? that.bedrooms == null : this.bedrooms.equals(that.bedrooms));
    equal = equal && (this.beds == null ? that.beds == null : this.beds.equals(that.beds));
    equal = equal && (this.bed_type == null ? that.bed_type == null : this.bed_type.equals(that.bed_type));
    equal = equal && (this.square_feet == null ? that.square_feet == null : this.square_feet.equals(that.square_feet));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.number_of_reviews == null ? that.number_of_reviews == null : this.number_of_reviews.equals(that.number_of_reviews));
    equal = equal && (this.review_scores_rating == null ? that.review_scores_rating == null : this.review_scores_rating.equals(that.review_scores_rating));
    equal = equal && (this.review_scores_cleanliness == null ? that.review_scores_cleanliness == null : this.review_scores_cleanliness.equals(that.review_scores_cleanliness));
    equal = equal && (this.review_scores_location == null ? that.review_scores_location == null : this.review_scores_location.equals(that.review_scores_location));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.name = JdbcWritableBridge.readString(2, __dbResults);
    this.neighborhood_overview = JdbcWritableBridge.readString(3, __dbResults);
    this.transit = JdbcWritableBridge.readString(4, __dbResults);
    this.neighbourhood = JdbcWritableBridge.readString(5, __dbResults);
    this.city = JdbcWritableBridge.readString(6, __dbResults);
    this.state = JdbcWritableBridge.readString(7, __dbResults);
    this.country = JdbcWritableBridge.readString(8, __dbResults);
    this.zipcode = JdbcWritableBridge.readString(9, __dbResults);
    this.summary = JdbcWritableBridge.readString(10, __dbResults);
    this.property_type = JdbcWritableBridge.readString(11, __dbResults);
    this.room_type = JdbcWritableBridge.readString(12, __dbResults);
    this.accommodates = JdbcWritableBridge.readDouble(13, __dbResults);
    this.bathrooms = JdbcWritableBridge.readDouble(14, __dbResults);
    this.bedrooms = JdbcWritableBridge.readDouble(15, __dbResults);
    this.beds = JdbcWritableBridge.readDouble(16, __dbResults);
    this.bed_type = JdbcWritableBridge.readString(17, __dbResults);
    this.square_feet = JdbcWritableBridge.readDouble(18, __dbResults);
    this.price = JdbcWritableBridge.readDouble(19, __dbResults);
    this.number_of_reviews = JdbcWritableBridge.readDouble(20, __dbResults);
    this.review_scores_rating = JdbcWritableBridge.readDouble(21, __dbResults);
    this.review_scores_cleanliness = JdbcWritableBridge.readDouble(22, __dbResults);
    this.review_scores_location = JdbcWritableBridge.readDouble(23, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(24, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(25, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.name = JdbcWritableBridge.readString(2, __dbResults);
    this.neighborhood_overview = JdbcWritableBridge.readString(3, __dbResults);
    this.transit = JdbcWritableBridge.readString(4, __dbResults);
    this.neighbourhood = JdbcWritableBridge.readString(5, __dbResults);
    this.city = JdbcWritableBridge.readString(6, __dbResults);
    this.state = JdbcWritableBridge.readString(7, __dbResults);
    this.country = JdbcWritableBridge.readString(8, __dbResults);
    this.zipcode = JdbcWritableBridge.readString(9, __dbResults);
    this.summary = JdbcWritableBridge.readString(10, __dbResults);
    this.property_type = JdbcWritableBridge.readString(11, __dbResults);
    this.room_type = JdbcWritableBridge.readString(12, __dbResults);
    this.accommodates = JdbcWritableBridge.readDouble(13, __dbResults);
    this.bathrooms = JdbcWritableBridge.readDouble(14, __dbResults);
    this.bedrooms = JdbcWritableBridge.readDouble(15, __dbResults);
    this.beds = JdbcWritableBridge.readDouble(16, __dbResults);
    this.bed_type = JdbcWritableBridge.readString(17, __dbResults);
    this.square_feet = JdbcWritableBridge.readDouble(18, __dbResults);
    this.price = JdbcWritableBridge.readDouble(19, __dbResults);
    this.number_of_reviews = JdbcWritableBridge.readDouble(20, __dbResults);
    this.review_scores_rating = JdbcWritableBridge.readDouble(21, __dbResults);
    this.review_scores_cleanliness = JdbcWritableBridge.readDouble(22, __dbResults);
    this.review_scores_location = JdbcWritableBridge.readDouble(23, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(24, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(25, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(neighborhood_overview, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(transit, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(neighbourhood, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(country, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zipcode, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(summary, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(property_type, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(room_type, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(accommodates, 13 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(bathrooms, 14 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(bedrooms, 15 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(beds, 16 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(bed_type, 17 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(square_feet, 18 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(price, 19 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(number_of_reviews, 20 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(review_scores_rating, 21 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(review_scores_cleanliness, 22 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(review_scores_location, 23 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 24 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 25 + __off, 2, __dbStmt);
    return 25;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(neighborhood_overview, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(transit, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(neighbourhood, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(city, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(country, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zipcode, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(summary, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(property_type, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(room_type, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(accommodates, 13 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(bathrooms, 14 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(bedrooms, 15 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(beds, 16 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(bed_type, 17 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(square_feet, 18 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(price, 19 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(number_of_reviews, 20 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(review_scores_rating, 21 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(review_scores_cleanliness, 22 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(review_scores_location, 23 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 24 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 25 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.name = null;
    } else {
    this.name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.neighborhood_overview = null;
    } else {
    this.neighborhood_overview = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.transit = null;
    } else {
    this.transit = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.neighbourhood = null;
    } else {
    this.neighbourhood = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.city = null;
    } else {
    this.city = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.state = null;
    } else {
    this.state = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.country = null;
    } else {
    this.country = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.zipcode = null;
    } else {
    this.zipcode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.summary = null;
    } else {
    this.summary = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.property_type = null;
    } else {
    this.property_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.room_type = null;
    } else {
    this.room_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.accommodates = null;
    } else {
    this.accommodates = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.bathrooms = null;
    } else {
    this.bathrooms = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.bedrooms = null;
    } else {
    this.bedrooms = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.beds = null;
    } else {
    this.beds = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.bed_type = null;
    } else {
    this.bed_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.square_feet = null;
    } else {
    this.square_feet = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.price = null;
    } else {
    this.price = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.number_of_reviews = null;
    } else {
    this.number_of_reviews = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.review_scores_rating = null;
    } else {
    this.review_scores_rating = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.review_scores_cleanliness = null;
    } else {
    this.review_scores_cleanliness = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.review_scores_location = null;
    } else {
    this.review_scores_location = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.latitude = null;
    } else {
    this.latitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.longitude = null;
    } else {
    this.longitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, name);
    }
    if (null == this.neighborhood_overview) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, neighborhood_overview);
    }
    if (null == this.transit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, transit);
    }
    if (null == this.neighbourhood) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, neighbourhood);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.country) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, country);
    }
    if (null == this.zipcode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zipcode);
    }
    if (null == this.summary) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, summary);
    }
    if (null == this.property_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, property_type);
    }
    if (null == this.room_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, room_type);
    }
    if (null == this.accommodates) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.accommodates);
    }
    if (null == this.bathrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.bathrooms);
    }
    if (null == this.bedrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.bedrooms);
    }
    if (null == this.beds) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.beds);
    }
    if (null == this.bed_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, bed_type);
    }
    if (null == this.square_feet) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.square_feet);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.price);
    }
    if (null == this.number_of_reviews) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.number_of_reviews);
    }
    if (null == this.review_scores_rating) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.review_scores_rating);
    }
    if (null == this.review_scores_cleanliness) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.review_scores_cleanliness);
    }
    if (null == this.review_scores_location) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.review_scores_location);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, name);
    }
    if (null == this.neighborhood_overview) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, neighborhood_overview);
    }
    if (null == this.transit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, transit);
    }
    if (null == this.neighbourhood) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, neighbourhood);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.country) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, country);
    }
    if (null == this.zipcode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zipcode);
    }
    if (null == this.summary) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, summary);
    }
    if (null == this.property_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, property_type);
    }
    if (null == this.room_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, room_type);
    }
    if (null == this.accommodates) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.accommodates);
    }
    if (null == this.bathrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.bathrooms);
    }
    if (null == this.bedrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.bedrooms);
    }
    if (null == this.beds) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.beds);
    }
    if (null == this.bed_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, bed_type);
    }
    if (null == this.square_feet) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.square_feet);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.price);
    }
    if (null == this.number_of_reviews) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.number_of_reviews);
    }
    if (null == this.review_scores_rating) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.review_scores_rating);
    }
    if (null == this.review_scores_cleanliness) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.review_scores_cleanliness);
    }
    if (null == this.review_scores_location) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.review_scores_location);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(name==null?"null":name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(neighborhood_overview==null?"null":neighborhood_overview, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(transit==null?"null":transit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(neighbourhood==null?"null":neighbourhood, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(country==null?"null":country, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zipcode==null?"null":zipcode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(summary==null?"null":summary, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(property_type==null?"null":property_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(room_type==null?"null":room_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(accommodates==null?"null":"" + accommodates, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bathrooms==null?"null":"" + bathrooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bedrooms==null?"null":"" + bedrooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(beds==null?"null":"" + beds, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bed_type==null?"null":bed_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(square_feet==null?"null":"" + square_feet, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_reviews==null?"null":"" + number_of_reviews, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_rating==null?"null":"" + review_scores_rating, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_cleanliness==null?"null":"" + review_scores_cleanliness, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_location==null?"null":"" + review_scores_location, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(name==null?"null":name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(neighborhood_overview==null?"null":neighborhood_overview, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(transit==null?"null":transit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(neighbourhood==null?"null":neighbourhood, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(country==null?"null":country, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zipcode==null?"null":zipcode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(summary==null?"null":summary, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(property_type==null?"null":property_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(room_type==null?"null":room_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(accommodates==null?"null":"" + accommodates, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bathrooms==null?"null":"" + bathrooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bedrooms==null?"null":"" + bedrooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(beds==null?"null":"" + beds, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bed_type==null?"null":bed_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(square_feet==null?"null":"" + square_feet, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_reviews==null?"null":"" + number_of_reviews, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_rating==null?"null":"" + review_scores_rating, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_cleanliness==null?"null":"" + review_scores_cleanliness, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_location==null?"null":"" + review_scores_location, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.name = null; } else {
      this.name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.neighborhood_overview = null; } else {
      this.neighborhood_overview = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.transit = null; } else {
      this.transit = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.neighbourhood = null; } else {
      this.neighbourhood = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.country = null; } else {
      this.country = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zipcode = null; } else {
      this.zipcode = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.summary = null; } else {
      this.summary = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.property_type = null; } else {
      this.property_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.room_type = null; } else {
      this.room_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.accommodates = null; } else {
      this.accommodates = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bathrooms = null; } else {
      this.bathrooms = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bedrooms = null; } else {
      this.bedrooms = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.beds = null; } else {
      this.beds = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.bed_type = null; } else {
      this.bed_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.square_feet = null; } else {
      this.square_feet = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_reviews = null; } else {
      this.number_of_reviews = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_rating = null; } else {
      this.review_scores_rating = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_cleanliness = null; } else {
      this.review_scores_cleanliness = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_location = null; } else {
      this.review_scores_location = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.name = null; } else {
      this.name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.neighborhood_overview = null; } else {
      this.neighborhood_overview = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.transit = null; } else {
      this.transit = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.neighbourhood = null; } else {
      this.neighbourhood = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.country = null; } else {
      this.country = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zipcode = null; } else {
      this.zipcode = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.summary = null; } else {
      this.summary = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.property_type = null; } else {
      this.property_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.room_type = null; } else {
      this.room_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.accommodates = null; } else {
      this.accommodates = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bathrooms = null; } else {
      this.bathrooms = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bedrooms = null; } else {
      this.bedrooms = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.beds = null; } else {
      this.beds = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.bed_type = null; } else {
      this.bed_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.square_feet = null; } else {
      this.square_feet = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_reviews = null; } else {
      this.number_of_reviews = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_rating = null; } else {
      this.review_scores_rating = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_cleanliness = null; } else {
      this.review_scores_cleanliness = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_location = null; } else {
      this.review_scores_location = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    codegen_airbnb o = (codegen_airbnb) super.clone();
    return o;
  }

  public void clone0(codegen_airbnb o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("name", this.name);
    __sqoop$field_map.put("neighborhood_overview", this.neighborhood_overview);
    __sqoop$field_map.put("transit", this.transit);
    __sqoop$field_map.put("neighbourhood", this.neighbourhood);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("country", this.country);
    __sqoop$field_map.put("zipcode", this.zipcode);
    __sqoop$field_map.put("summary", this.summary);
    __sqoop$field_map.put("property_type", this.property_type);
    __sqoop$field_map.put("room_type", this.room_type);
    __sqoop$field_map.put("accommodates", this.accommodates);
    __sqoop$field_map.put("bathrooms", this.bathrooms);
    __sqoop$field_map.put("bedrooms", this.bedrooms);
    __sqoop$field_map.put("beds", this.beds);
    __sqoop$field_map.put("bed_type", this.bed_type);
    __sqoop$field_map.put("square_feet", this.square_feet);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("number_of_reviews", this.number_of_reviews);
    __sqoop$field_map.put("review_scores_rating", this.review_scores_rating);
    __sqoop$field_map.put("review_scores_cleanliness", this.review_scores_cleanliness);
    __sqoop$field_map.put("review_scores_location", this.review_scores_location);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("longitude", this.longitude);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("name", this.name);
    __sqoop$field_map.put("neighborhood_overview", this.neighborhood_overview);
    __sqoop$field_map.put("transit", this.transit);
    __sqoop$field_map.put("neighbourhood", this.neighbourhood);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("country", this.country);
    __sqoop$field_map.put("zipcode", this.zipcode);
    __sqoop$field_map.put("summary", this.summary);
    __sqoop$field_map.put("property_type", this.property_type);
    __sqoop$field_map.put("room_type", this.room_type);
    __sqoop$field_map.put("accommodates", this.accommodates);
    __sqoop$field_map.put("bathrooms", this.bathrooms);
    __sqoop$field_map.put("bedrooms", this.bedrooms);
    __sqoop$field_map.put("beds", this.beds);
    __sqoop$field_map.put("bed_type", this.bed_type);
    __sqoop$field_map.put("square_feet", this.square_feet);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("number_of_reviews", this.number_of_reviews);
    __sqoop$field_map.put("review_scores_rating", this.review_scores_rating);
    __sqoop$field_map.put("review_scores_cleanliness", this.review_scores_cleanliness);
    __sqoop$field_map.put("review_scores_location", this.review_scores_location);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("longitude", this.longitude);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
