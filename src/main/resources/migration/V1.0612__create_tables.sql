CREATE TABLE IF NOT EXISTS Instructor (
    ID BIGSERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Bio TEXT,
    Registration_Date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS Category (
    ID BIGSERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS Course (
    ID BIGSERIAL PRIMARY KEY,
    Title VARCHAR(200) NOT NULL,
    Description TEXT,
    Duration INT NOT NULL,
    Price INT NOT NULL,
    Instructor_ID BIGINT REFERENCES Instructor(ID) ON DELETE SET NULL,
    Category_ID BIGINT REFERENCES Category(ID) ON DELETE SET NULL,
    Total_Enrollments INT DEFAULT 0 CHECK (Total_Enrollments >= 0),
    Average_Rating FLOAT DEFAULT 0.0 CHECK (Average_Rating BETWEEN 0 AND 5),
    Creation_Date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS Student (
    ID BIGSERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Date_Of_Birth DATE NOT NULL,
    Registration_Date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS Enrollment (
    ID BIGSERIAL PRIMARY KEY,
    Student_ID BIGINT REFERENCES Student(ID) ON DELETE CASCADE,
    Course_ID BIGINT REFERENCES Course(ID) ON DELETE CASCADE,
    Enrollment_Date DATE DEFAULT CURRENT_DATE,
    Completion_Status BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Feedback (
    ID BIGSERIAL PRIMARY KEY,
    Student_ID BIGINT REFERENCES Student(ID) ON DELETE CASCADE,
    Course_ID BIGINT REFERENCES Course(ID) ON DELETE CASCADE,
    Rating FLOAT NOT NULL CHECK (Rating BETWEEN 0 AND 5),
    Comment TEXT,
    Feedback_Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


