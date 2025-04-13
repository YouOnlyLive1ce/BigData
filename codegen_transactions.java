// ORM class for table 'transactions'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sat Apr 05 13:13:41 MSK 2025
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

public class codegen_transactions extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("time", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.time = (java.sql.Timestamp)value;
      }
    });
    setters.put("hour_of_day", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.hour_of_day = (Integer)value;
      }
    });
    setters.put("sending_address", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.sending_address = (String)value;
      }
    });
    setters.put("receiving_address", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.receiving_address = (String)value;
      }
    });
    setters.put("amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.amount = (Double)value;
      }
    });
    setters.put("transaction_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.transaction_type = (String)value;
      }
    });
    setters.put("location_region", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.location_region = (String)value;
      }
    });
    setters.put("ip_prefix", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.ip_prefix = (String)value;
      }
    });
    setters.put("login_frequency", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.login_frequency = (Integer)value;
      }
    });
    setters.put("session_duration", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.session_duration = (Integer)value;
      }
    });
    setters.put("purchase_pattern", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.purchase_pattern = (String)value;
      }
    });
    setters.put("age_group", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.age_group = (String)value;
      }
    });
    setters.put("risk_score", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.risk_score = (Double)value;
      }
    });
    setters.put("anomaly", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        codegen_transactions.this.anomaly = (String)value;
      }
    });
  }
  public codegen_transactions() {
    init0();
  }
  private java.sql.Timestamp time;
  public java.sql.Timestamp get_time() {
    return time;
  }
  public void set_time(java.sql.Timestamp time) {
    this.time = time;
  }
  public codegen_transactions with_time(java.sql.Timestamp time) {
    this.time = time;
    return this;
  }
  private Integer hour_of_day;
  public Integer get_hour_of_day() {
    return hour_of_day;
  }
  public void set_hour_of_day(Integer hour_of_day) {
    this.hour_of_day = hour_of_day;
  }
  public codegen_transactions with_hour_of_day(Integer hour_of_day) {
    this.hour_of_day = hour_of_day;
    return this;
  }
  private String sending_address;
  public String get_sending_address() {
    return sending_address;
  }
  public void set_sending_address(String sending_address) {
    this.sending_address = sending_address;
  }
  public codegen_transactions with_sending_address(String sending_address) {
    this.sending_address = sending_address;
    return this;
  }
  private String receiving_address;
  public String get_receiving_address() {
    return receiving_address;
  }
  public void set_receiving_address(String receiving_address) {
    this.receiving_address = receiving_address;
  }
  public codegen_transactions with_receiving_address(String receiving_address) {
    this.receiving_address = receiving_address;
    return this;
  }
  private Double amount;
  public Double get_amount() {
    return amount;
  }
  public void set_amount(Double amount) {
    this.amount = amount;
  }
  public codegen_transactions with_amount(Double amount) {
    this.amount = amount;
    return this;
  }
  private String transaction_type;
  public String get_transaction_type() {
    return transaction_type;
  }
  public void set_transaction_type(String transaction_type) {
    this.transaction_type = transaction_type;
  }
  public codegen_transactions with_transaction_type(String transaction_type) {
    this.transaction_type = transaction_type;
    return this;
  }
  private String location_region;
  public String get_location_region() {
    return location_region;
  }
  public void set_location_region(String location_region) {
    this.location_region = location_region;
  }
  public codegen_transactions with_location_region(String location_region) {
    this.location_region = location_region;
    return this;
  }
  private String ip_prefix;
  public String get_ip_prefix() {
    return ip_prefix;
  }
  public void set_ip_prefix(String ip_prefix) {
    this.ip_prefix = ip_prefix;
  }
  public codegen_transactions with_ip_prefix(String ip_prefix) {
    this.ip_prefix = ip_prefix;
    return this;
  }
  private Integer login_frequency;
  public Integer get_login_frequency() {
    return login_frequency;
  }
  public void set_login_frequency(Integer login_frequency) {
    this.login_frequency = login_frequency;
  }
  public codegen_transactions with_login_frequency(Integer login_frequency) {
    this.login_frequency = login_frequency;
    return this;
  }
  private Integer session_duration;
  public Integer get_session_duration() {
    return session_duration;
  }
  public void set_session_duration(Integer session_duration) {
    this.session_duration = session_duration;
  }
  public codegen_transactions with_session_duration(Integer session_duration) {
    this.session_duration = session_duration;
    return this;
  }
  private String purchase_pattern;
  public String get_purchase_pattern() {
    return purchase_pattern;
  }
  public void set_purchase_pattern(String purchase_pattern) {
    this.purchase_pattern = purchase_pattern;
  }
  public codegen_transactions with_purchase_pattern(String purchase_pattern) {
    this.purchase_pattern = purchase_pattern;
    return this;
  }
  private String age_group;
  public String get_age_group() {
    return age_group;
  }
  public void set_age_group(String age_group) {
    this.age_group = age_group;
  }
  public codegen_transactions with_age_group(String age_group) {
    this.age_group = age_group;
    return this;
  }
  private Double risk_score;
  public Double get_risk_score() {
    return risk_score;
  }
  public void set_risk_score(Double risk_score) {
    this.risk_score = risk_score;
  }
  public codegen_transactions with_risk_score(Double risk_score) {
    this.risk_score = risk_score;
    return this;
  }
  private String anomaly;
  public String get_anomaly() {
    return anomaly;
  }
  public void set_anomaly(String anomaly) {
    this.anomaly = anomaly;
  }
  public codegen_transactions with_anomaly(String anomaly) {
    this.anomaly = anomaly;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof codegen_transactions)) {
      return false;
    }
    codegen_transactions that = (codegen_transactions) o;
    boolean equal = true;
    equal = equal && (this.time == null ? that.time == null : this.time.equals(that.time));
    equal = equal && (this.hour_of_day == null ? that.hour_of_day == null : this.hour_of_day.equals(that.hour_of_day));
    equal = equal && (this.sending_address == null ? that.sending_address == null : this.sending_address.equals(that.sending_address));
    equal = equal && (this.receiving_address == null ? that.receiving_address == null : this.receiving_address.equals(that.receiving_address));
    equal = equal && (this.amount == null ? that.amount == null : this.amount.equals(that.amount));
    equal = equal && (this.transaction_type == null ? that.transaction_type == null : this.transaction_type.equals(that.transaction_type));
    equal = equal && (this.location_region == null ? that.location_region == null : this.location_region.equals(that.location_region));
    equal = equal && (this.ip_prefix == null ? that.ip_prefix == null : this.ip_prefix.equals(that.ip_prefix));
    equal = equal && (this.login_frequency == null ? that.login_frequency == null : this.login_frequency.equals(that.login_frequency));
    equal = equal && (this.session_duration == null ? that.session_duration == null : this.session_duration.equals(that.session_duration));
    equal = equal && (this.purchase_pattern == null ? that.purchase_pattern == null : this.purchase_pattern.equals(that.purchase_pattern));
    equal = equal && (this.age_group == null ? that.age_group == null : this.age_group.equals(that.age_group));
    equal = equal && (this.risk_score == null ? that.risk_score == null : this.risk_score.equals(that.risk_score));
    equal = equal && (this.anomaly == null ? that.anomaly == null : this.anomaly.equals(that.anomaly));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof codegen_transactions)) {
      return false;
    }
    codegen_transactions that = (codegen_transactions) o;
    boolean equal = true;
    equal = equal && (this.time == null ? that.time == null : this.time.equals(that.time));
    equal = equal && (this.hour_of_day == null ? that.hour_of_day == null : this.hour_of_day.equals(that.hour_of_day));
    equal = equal && (this.sending_address == null ? that.sending_address == null : this.sending_address.equals(that.sending_address));
    equal = equal && (this.receiving_address == null ? that.receiving_address == null : this.receiving_address.equals(that.receiving_address));
    equal = equal && (this.amount == null ? that.amount == null : this.amount.equals(that.amount));
    equal = equal && (this.transaction_type == null ? that.transaction_type == null : this.transaction_type.equals(that.transaction_type));
    equal = equal && (this.location_region == null ? that.location_region == null : this.location_region.equals(that.location_region));
    equal = equal && (this.ip_prefix == null ? that.ip_prefix == null : this.ip_prefix.equals(that.ip_prefix));
    equal = equal && (this.login_frequency == null ? that.login_frequency == null : this.login_frequency.equals(that.login_frequency));
    equal = equal && (this.session_duration == null ? that.session_duration == null : this.session_duration.equals(that.session_duration));
    equal = equal && (this.purchase_pattern == null ? that.purchase_pattern == null : this.purchase_pattern.equals(that.purchase_pattern));
    equal = equal && (this.age_group == null ? that.age_group == null : this.age_group.equals(that.age_group));
    equal = equal && (this.risk_score == null ? that.risk_score == null : this.risk_score.equals(that.risk_score));
    equal = equal && (this.anomaly == null ? that.anomaly == null : this.anomaly.equals(that.anomaly));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.time = JdbcWritableBridge.readTimestamp(1, __dbResults);
    this.hour_of_day = JdbcWritableBridge.readInteger(2, __dbResults);
    this.sending_address = JdbcWritableBridge.readString(3, __dbResults);
    this.receiving_address = JdbcWritableBridge.readString(4, __dbResults);
    this.amount = JdbcWritableBridge.readDouble(5, __dbResults);
    this.transaction_type = JdbcWritableBridge.readString(6, __dbResults);
    this.location_region = JdbcWritableBridge.readString(7, __dbResults);
    this.ip_prefix = JdbcWritableBridge.readString(8, __dbResults);
    this.login_frequency = JdbcWritableBridge.readInteger(9, __dbResults);
    this.session_duration = JdbcWritableBridge.readInteger(10, __dbResults);
    this.purchase_pattern = JdbcWritableBridge.readString(11, __dbResults);
    this.age_group = JdbcWritableBridge.readString(12, __dbResults);
    this.risk_score = JdbcWritableBridge.readDouble(13, __dbResults);
    this.anomaly = JdbcWritableBridge.readString(14, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.time = JdbcWritableBridge.readTimestamp(1, __dbResults);
    this.hour_of_day = JdbcWritableBridge.readInteger(2, __dbResults);
    this.sending_address = JdbcWritableBridge.readString(3, __dbResults);
    this.receiving_address = JdbcWritableBridge.readString(4, __dbResults);
    this.amount = JdbcWritableBridge.readDouble(5, __dbResults);
    this.transaction_type = JdbcWritableBridge.readString(6, __dbResults);
    this.location_region = JdbcWritableBridge.readString(7, __dbResults);
    this.ip_prefix = JdbcWritableBridge.readString(8, __dbResults);
    this.login_frequency = JdbcWritableBridge.readInteger(9, __dbResults);
    this.session_duration = JdbcWritableBridge.readInteger(10, __dbResults);
    this.purchase_pattern = JdbcWritableBridge.readString(11, __dbResults);
    this.age_group = JdbcWritableBridge.readString(12, __dbResults);
    this.risk_score = JdbcWritableBridge.readDouble(13, __dbResults);
    this.anomaly = JdbcWritableBridge.readString(14, __dbResults);
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
    JdbcWritableBridge.writeTimestamp(time, 1 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(hour_of_day, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(sending_address, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(receiving_address, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(amount, 5 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(transaction_type, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(location_region, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(ip_prefix, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(login_frequency, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(session_duration, 10 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(purchase_pattern, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(age_group, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(risk_score, 13 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(anomaly, 14 + __off, 12, __dbStmt);
    return 14;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeTimestamp(time, 1 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(hour_of_day, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(sending_address, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(receiving_address, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(amount, 5 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(transaction_type, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(location_region, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(ip_prefix, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(login_frequency, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(session_duration, 10 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(purchase_pattern, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(age_group, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(risk_score, 13 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeString(anomaly, 14 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.time = null;
    } else {
    this.time = new Timestamp(__dataIn.readLong());
    this.time.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.hour_of_day = null;
    } else {
    this.hour_of_day = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.sending_address = null;
    } else {
    this.sending_address = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.receiving_address = null;
    } else {
    this.receiving_address = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.amount = null;
    } else {
    this.amount = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.transaction_type = null;
    } else {
    this.transaction_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.location_region = null;
    } else {
    this.location_region = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ip_prefix = null;
    } else {
    this.ip_prefix = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.login_frequency = null;
    } else {
    this.login_frequency = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.session_duration = null;
    } else {
    this.session_duration = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.purchase_pattern = null;
    } else {
    this.purchase_pattern = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.age_group = null;
    } else {
    this.age_group = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.risk_score = null;
    } else {
    this.risk_score = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.anomaly = null;
    } else {
    this.anomaly = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time.getTime());
    __dataOut.writeInt(this.time.getNanos());
    }
    if (null == this.hour_of_day) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.hour_of_day);
    }
    if (null == this.sending_address) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sending_address);
    }
    if (null == this.receiving_address) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, receiving_address);
    }
    if (null == this.amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.amount);
    }
    if (null == this.transaction_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, transaction_type);
    }
    if (null == this.location_region) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, location_region);
    }
    if (null == this.ip_prefix) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ip_prefix);
    }
    if (null == this.login_frequency) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.login_frequency);
    }
    if (null == this.session_duration) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.session_duration);
    }
    if (null == this.purchase_pattern) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, purchase_pattern);
    }
    if (null == this.age_group) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, age_group);
    }
    if (null == this.risk_score) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.risk_score);
    }
    if (null == this.anomaly) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, anomaly);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time.getTime());
    __dataOut.writeInt(this.time.getNanos());
    }
    if (null == this.hour_of_day) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.hour_of_day);
    }
    if (null == this.sending_address) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sending_address);
    }
    if (null == this.receiving_address) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, receiving_address);
    }
    if (null == this.amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.amount);
    }
    if (null == this.transaction_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, transaction_type);
    }
    if (null == this.location_region) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, location_region);
    }
    if (null == this.ip_prefix) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ip_prefix);
    }
    if (null == this.login_frequency) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.login_frequency);
    }
    if (null == this.session_duration) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.session_duration);
    }
    if (null == this.purchase_pattern) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, purchase_pattern);
    }
    if (null == this.age_group) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, age_group);
    }
    if (null == this.risk_score) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.risk_score);
    }
    if (null == this.anomaly) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, anomaly);
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
    __sb.append(FieldFormatter.escapeAndEnclose(time==null?"null":"" + time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(hour_of_day==null?"null":"" + hour_of_day, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sending_address==null?"null":sending_address, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(receiving_address==null?"null":receiving_address, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(amount==null?"null":"" + amount, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(transaction_type==null?"null":transaction_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(location_region==null?"null":location_region, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ip_prefix==null?"null":ip_prefix, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(login_frequency==null?"null":"" + login_frequency, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(session_duration==null?"null":"" + session_duration, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(purchase_pattern==null?"null":purchase_pattern, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(age_group==null?"null":age_group, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(risk_score==null?"null":"" + risk_score, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(anomaly==null?"null":anomaly, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(time==null?"null":"" + time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(hour_of_day==null?"null":"" + hour_of_day, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sending_address==null?"null":sending_address, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(receiving_address==null?"null":receiving_address, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(amount==null?"null":"" + amount, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(transaction_type==null?"null":transaction_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(location_region==null?"null":location_region, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ip_prefix==null?"null":ip_prefix, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(login_frequency==null?"null":"" + login_frequency, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(session_duration==null?"null":"" + session_duration, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(purchase_pattern==null?"null":purchase_pattern, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(age_group==null?"null":age_group, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(risk_score==null?"null":"" + risk_score, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(anomaly==null?"null":anomaly, delimiters));
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time = null; } else {
      this.time = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.hour_of_day = null; } else {
      this.hour_of_day = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.sending_address = null; } else {
      this.sending_address = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.receiving_address = null; } else {
      this.receiving_address = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.amount = null; } else {
      this.amount = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.transaction_type = null; } else {
      this.transaction_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.location_region = null; } else {
      this.location_region = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.ip_prefix = null; } else {
      this.ip_prefix = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.login_frequency = null; } else {
      this.login_frequency = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.session_duration = null; } else {
      this.session_duration = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.purchase_pattern = null; } else {
      this.purchase_pattern = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.age_group = null; } else {
      this.age_group = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.risk_score = null; } else {
      this.risk_score = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.anomaly = null; } else {
      this.anomaly = __cur_str;
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time = null; } else {
      this.time = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.hour_of_day = null; } else {
      this.hour_of_day = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.sending_address = null; } else {
      this.sending_address = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.receiving_address = null; } else {
      this.receiving_address = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.amount = null; } else {
      this.amount = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.transaction_type = null; } else {
      this.transaction_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.location_region = null; } else {
      this.location_region = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.ip_prefix = null; } else {
      this.ip_prefix = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.login_frequency = null; } else {
      this.login_frequency = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.session_duration = null; } else {
      this.session_duration = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.purchase_pattern = null; } else {
      this.purchase_pattern = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.age_group = null; } else {
      this.age_group = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.risk_score = null; } else {
      this.risk_score = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.anomaly = null; } else {
      this.anomaly = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    codegen_transactions o = (codegen_transactions) super.clone();
    o.time = (o.time != null) ? (java.sql.Timestamp) o.time.clone() : null;
    return o;
  }

  public void clone0(codegen_transactions o) throws CloneNotSupportedException {
    o.time = (o.time != null) ? (java.sql.Timestamp) o.time.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("time", this.time);
    __sqoop$field_map.put("hour_of_day", this.hour_of_day);
    __sqoop$field_map.put("sending_address", this.sending_address);
    __sqoop$field_map.put("receiving_address", this.receiving_address);
    __sqoop$field_map.put("amount", this.amount);
    __sqoop$field_map.put("transaction_type", this.transaction_type);
    __sqoop$field_map.put("location_region", this.location_region);
    __sqoop$field_map.put("ip_prefix", this.ip_prefix);
    __sqoop$field_map.put("login_frequency", this.login_frequency);
    __sqoop$field_map.put("session_duration", this.session_duration);
    __sqoop$field_map.put("purchase_pattern", this.purchase_pattern);
    __sqoop$field_map.put("age_group", this.age_group);
    __sqoop$field_map.put("risk_score", this.risk_score);
    __sqoop$field_map.put("anomaly", this.anomaly);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("time", this.time);
    __sqoop$field_map.put("hour_of_day", this.hour_of_day);
    __sqoop$field_map.put("sending_address", this.sending_address);
    __sqoop$field_map.put("receiving_address", this.receiving_address);
    __sqoop$field_map.put("amount", this.amount);
    __sqoop$field_map.put("transaction_type", this.transaction_type);
    __sqoop$field_map.put("location_region", this.location_region);
    __sqoop$field_map.put("ip_prefix", this.ip_prefix);
    __sqoop$field_map.put("login_frequency", this.login_frequency);
    __sqoop$field_map.put("session_duration", this.session_duration);
    __sqoop$field_map.put("purchase_pattern", this.purchase_pattern);
    __sqoop$field_map.put("age_group", this.age_group);
    __sqoop$field_map.put("risk_score", this.risk_score);
    __sqoop$field_map.put("anomaly", this.anomaly);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
