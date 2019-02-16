CREATE TABLE Videos(
    videoId INT,
    videoLink TEXT
);

CREATE TABLE Comments(
    commentId INT,
    commentText TEXT,
    score FLOAT,
    videoId INT
);
