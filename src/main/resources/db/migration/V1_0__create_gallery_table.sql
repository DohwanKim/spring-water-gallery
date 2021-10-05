CREATE TABLE IF NOT EXISTS gallery
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(256) NOT NULL UNIQUE,
    description VARCHAR(256) NOT NULL,
    content     MEDIUMTEXT,
    completed   DATETIME,
    created_at  DATETIME     NOT NULL DEFAULT NOW(),
    updated_at  DATETIME     NOT NULL
)
