-- Core tables for BudgetApp (Postgres)
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  email text UNIQUE,
  created_at timestamptz DEFAULT now()
);

CREATE TABLE bank_connections (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid REFERENCES users(id),
  provider text,
  provider_account_id text,
  access_token text,
  refresh_token text,
  token_expires_at timestamptz,
  created_at timestamptz DEFAULT now()
);

CREATE TABLE accounts (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  connection_id uuid REFERENCES bank_connections(id),
  account_id text,
  iban text,
  currency text,
  name text,
  balance numeric,
  last_synced timestamptz
);

CREATE TABLE transactions (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  account_id uuid REFERENCES accounts(id),
  tx_id text,
  amount numeric,
  currency text,
  description text,
  booking_date date,
  value_date date,
  category_id uuid,
  raw_json jsonb,
  import_source text,
  created_at timestamptz DEFAULT now()
);

CREATE TABLE categories (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  name text NOT NULL,
  parent_id uuid REFERENCES categories(id),
  path text NOT NULL,
  level int NOT NULL,
  sort_order int DEFAULT 0,
  created_at timestamptz DEFAULT now()
);

CREATE TABLE labels (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid REFERENCES users(id),
  name text NOT NULL
);

CREATE TABLE transaction_labels (
  transaction_id uuid REFERENCES transactions(id),
  label_id uuid REFERENCES labels(id),
  PRIMARY KEY (transaction_id, label_id)
);
