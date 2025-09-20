-- Sample data for testing the Quote Negotiation API

-- Insert Regions
INSERT INTO region (region_id, name) VALUES (1, 'North America');
INSERT INTO region (region_id, name) VALUES (2, 'Europe');
INSERT INTO region (region_id, name) VALUES (3, 'Asia Pacific');

-- Insert Customers
INSERT INTO customer (customer_id, name, region_id, customer_tier) VALUES (1, 'Acme Corp', 1, 'GOLD');
INSERT INTO customer (customer_id, name, region_id, customer_tier) VALUES (2, 'TechStart Inc', 1, 'SILVER');
INSERT INTO customer (customer_id, name, region_id, customer_tier) VALUES (3, 'Global Solutions', 2, 'STANDARD');
INSERT INTO customer (customer_id, name, region_id, customer_tier) VALUES (4, 'Innovation Labs', 3, 'GOLD');

-- Insert Products
INSERT INTO product (product_id, name, sku, description, list_price) VALUES (1, 'Enterprise Software License', 'ESL-001', 'Annual enterprise software license', 10000.00);
INSERT INTO product (product_id, name, sku, description, list_price) VALUES (2, 'Professional Services', 'PS-002', 'Professional consulting services per hour', 250.00);
INSERT INTO product (product_id, name, sku, description, list_price) VALUES (3, 'Cloud Storage Plan', 'CSP-003', 'Monthly cloud storage subscription', 99.99);
INSERT INTO product (product_id, name, sku, description, list_price) VALUES (4, 'Support Package', 'SP-004', 'Premium support package', 5000.00);
