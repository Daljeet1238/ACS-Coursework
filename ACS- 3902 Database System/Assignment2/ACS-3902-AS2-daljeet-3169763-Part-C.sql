-- ACS-3902 Assignment 2 Part C
-- Name: Daljeet Singh
-- St#: 3169763
--------------------------------
SET SCHEMA 'daljeet_3169763_as2_c';  


-- Q1
SELECT s.salesrepnumber, s.last, s.first
FROM sales_rep as s
	LEFT OUTER JOIN customer as c ON s.salesrepnumber = c.salesrepnumber
WHERE c.customer_number IS NULL;

-- Q2
SELECT s.salesrepnumber, s.last, s.first, 
		COUNT(so.order_number) as num_orders,
		SUM(ol.quoted_price * ol.qty_ordered) as total_value
FROM sales_rep s
	LEFT OUTER JOIN customer c ON s.salesrepnumber = c.salesrepnumber
	LEFT OUTER JOIN sales_order so ON c.customer_number = so.customer_number
	LEFT OUTER JOIN order_line ol ON so.order_number = ol.order_number
GROUP BY s.salesrepnumber, s.last, s.first
ORDER BY s.salesrepnumber;


-- Q3
SELECT c.customer_number, c.last as last_name, s.last as sales_last,
		SUM(ol.quoted_price * ol.qty_ordered) as total_sales,
		AVG(ol.quoted_price * ol.qty_ordered) as average_order_value
FROM customer c
	LEFT OUTER JOIN sales_rep s ON c.salesrepnumber = s.salesrepnumber
	LEFT OUTER JOIN sales_order so ON c.customer_number = so.customer_number
	LEFT OUTER JOIN order_line ol ON so.order_number = ol.order_number
GROUP BY c.customer_number, c.last, s.last
ORDER BY average_order_value DESC;


-- Q4
WITH average_unit_price AS (
	SELECT AVG(unit_price) as avg_price
	FROM part
)
SELECT p.part_number, p.part_description as part_name, p.unit_price, 
		SUM(qty_ordered) as total_quantity_sold,
		SUM(ol.qty_ordered * ol.quoted_price) as total_revenue_generated
FROM part p
	JOIN order_line ol ON p.part_number = ol.part_number
	CROSS JOIN average_unit_price aup
WHERE p.unit_price >= aup.avg_price
GROUP BY p.part_number, p.part_description, p.unit_price
ORDER BY total_quantity_sold DESC;	
		

-- Q5
WITH customer_sg_purchase AS (
	SELECT DISTINCT c.customer_number
	FROM customer c
	JOIN sales_order so ON c.customer_number = so.customer_number
    JOIN order_line ol ON so.order_number = ol.order_number
    JOIN part p ON ol.part_number = p.part_number
    JOIN item_class ic ON p.item_class_id = ic.item_class_id
    WHERE ic.item_class_code = 'SG'
)
SELECT c.customer_number, c.first, c.last,
		SUM(ol.qty_ordered * ol.quoted_price) AS total_order_value
FROM customer c
	JOIN sales_order so ON c.customer_number = so.customer_number
	JOIN order_line ol ON so.order_number = ol.order_number
WHERE c.customer_number IN(
	SELECT customer_number 
	FROM customer_sg_purchase
)	
GROUP BY c.customer_number, c.first, c.last
ORDER BY c.customer_number;
		
-- Q6
INSERT INTO sales_commision_payout (
    salesrepnumber,
    commissionrate,
    sales_year,
    sales_month_number,
    sales,
    commission
)
SELECT s.salesrepnumber, s.commission_rate,
    EXTRACT(YEAR FROM so.order_date) as sales_year,
    EXTRACT(MONTH FROM so.order_date) as sales_month_number,
    SUM(ol.quoted_price * ol.qty_ordered) AS sales,
    SUM(ol.quoted_price * ol.qty_ordered * s.commission_rate) AS commission
FROM sales_rep s
LEFT JOIN customer c ON s.salesrepnumber = c.salesrepnumber
LEFT JOIN sales_order so ON c.customer_number = so.customer_number
    AND EXTRACT(YEAR FROM so.order_date) = 2023 --sprcific year
    AND EXTRACT(MONTH FROM so.order_date) = 10 -- specific month
LEFT JOIN order_line ol ON so.order_number = ol.order_number
GROUP BY s.salesrepnumber, s.commission_rate
ORDER BY s.salesrepnumber;


