CREATE TABLE product
(
    id          UUID                        NOT NULL,
    name        VARCHAR(50)                 NOT NULL CHECK (char_length(name) > 1),
    description VARCHAR(500) CHECK (char_length(description) >= 5),
    price       DECIMAL(10, 2)              NOT NULL CHECK (price > 0),
    image_url   VARCHAR(200) CHECK (char_length(image_url) > 0),
    stock_level INTEGER                     NOT NULL CHECK (stock_level >= 0),
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    deleted_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_product PRIMARY KEY (id)
);