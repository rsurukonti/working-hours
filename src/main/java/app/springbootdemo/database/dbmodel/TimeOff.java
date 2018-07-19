package app.springbootdemo.database.dbmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "timeoff")

    public class TimeOff {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "timeoff_id")
        private long id;

        @Column(name = "leavetype")
        private String leaveType;

        @Column(name = "fromDate")
        private String fromDate;

        @Column(name = "toDate")
        private String toDate;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public String getFromDate() {
            return fromDate;
        }

        public void setFromDate(String fromDate) {
            this.fromDate = fromDate;
        }

        public String getToDate() {
            return toDate;
        }

        public void setToDate(String toDate) {
            this.toDate = toDate;
        }

        }

