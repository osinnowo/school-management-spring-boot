INSERT INTO public.users (id, date_created, date_modified, is_soft_deleted, date_of_birth, email, first_name, gender, last_name, phone_number)
VALUES
  (1, '2023-05-01', '2023-05-01', false, DATE '1990-01-01', 'user1@example.com', 'John', 'Male', 'Doe', '1234567890'),
  (2, '2023-05-02', '2023-05-02', false, DATE '1992-02-02', 'user2@example.com', 'Jane', 'Female', 'Smith', '2345678901'),
  (3, '2023-08-09', '2023-08-09', false, DATE '1998-12-31', 'user100@example.com', 'Sarah', 'Female', 'Williams', '9876543210');
