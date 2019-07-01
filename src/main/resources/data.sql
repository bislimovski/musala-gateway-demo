INSERT INTO gateway (serial_number, name, ip_address) VALUES (1,'MyGateway', '192.168.1.1');
INSERT INTO gateway (serial_number, name, ip_address) VALUES (2,'MyGateway2', '192.1.1.1');

INSERT INTO peripheral (uid, vendor, date_created, status, gateway_serial_number) VALUES (1, 'SBM', NOW(), 1, 1);
INSERT INTO peripheral (uid, vendor, date_created, status, gateway_serial_number) VALUES (2, 'SBM2', NOW(), 0, 1);
INSERT INTO peripheral (uid, vendor, date_created, status, gateway_serial_number) VALUES (3, 'SBM3', NOW(), 0, 2);