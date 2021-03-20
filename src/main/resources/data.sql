DROP TABLE IF EXISTS chat_log;
 
CREATE TABLE chat_log (
  id bigint AUTO_INCREMENT  PRIMARY KEY,
  user varchar(16),
  message varchar(5000),
  time_stamp TIMESTAMP,
  is_sent bit NOT NULL DEFAULT 0
);
