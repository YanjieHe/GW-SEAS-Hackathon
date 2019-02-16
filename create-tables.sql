CREATE TABLE Videos(
    videoId INT,
    videoLink INT
);

CREATE TABLE Comments(
    commentId INT,
    commentText TEXT,
    score FLOAT,
    videoId INT
);
