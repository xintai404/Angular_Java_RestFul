-- select orderNumber, orderdetails.productCode, quantityOrdered, priceEach, productName, productDescription
-- from orderdetails, products
-- where orderNumber = 10100 and orderdetails.productCode = products.productCode
-- order by orderLineNumber;

select contactFirstName, contactLastName, orderNumber, DATE_FORMAT(orderDate, '%m/%d/%Y') , status, shippedDate
from customers, orders
where customers.customerNumber = orders.customerNumber;


