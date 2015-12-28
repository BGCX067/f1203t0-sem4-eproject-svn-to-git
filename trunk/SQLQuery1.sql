create database ClaimProcessing
go

use ClaimProcessing
go

create table News
(
	NewsID int primary key,
	NewsTitle nvarchar(50) unique not null,
	NewsContent nvarchar(4000) not null,
	NewsCreatedDate date default getDate(),
	[Status] bit default 1
)

create table Contact
(
	ContactID int primary key,
	ContactTitle nvarchar(50) unique not null,
	ContactName nvarchar(50) not null,
	ContactEmail nvarchar(50) not null,
	ContactContent nvarchar(400) not null,
	ContactCreatedDate date default getDate(),
	[Status] bit default 1
)

create table BankInfo
(
	BankID int primary key,
	BankName nvarchar(50) unique not null,
	BankAddress nvarchar(50) unique not null,
	[Status] bit default 1
)

create table Employee
(
	EmployeeID nvarchar(10) primary key,
	EmployeeFirstName nvarchar(20) not null,
	EmployeeMiddleName nvarchar(20),
	EmployeeLastName nvarchar(20) not null,
	EmployeeDateOfBirth date not null,
	EmployeeAccountCode nvarchar(10) unique not null,
	EmployeeCreatedDate date default getDate(),
	[Status] bit default 1
)

create table Account
(
	AccountID int primary key,
	AccountUsername nvarchar(50) unique not null,
	AccountPassword nvarchar(50) not null,
	EmployeeID nvarchar(10) foreign key references Employee(EmployeeID) on update cascade on delete set null,
	AccountEmail nvarchar(50) unique not null,
	AccountAddress nvarchar(50) not null,
	AccountPhoneNumber nvarchar(10),
	AccountImage nvarchar(50) default 'na.jpg',
	AccountBankID int foreign key references BankInfo(BankID) on update cascade on delete set null,
	AccountBankCode nvarchar(16) unique not null,
	AccountCreatedDate date default getDate(),
	[Status] bit default 1
)

create table InsuranceType
(
	InsuranceTypeID int primary key,
	InsuranceTypeName nvarchar(50) unique not null,
	InsuranceTypeDescription nvarchar(4000) not null,
	InsuranceTypeMaximumReimbursement float not null,
	InsuranceTypeCreatedDate date default getDate(),
	[Status] bit default 1
)

create table Insurance
(
	InsuranceID int primary key,
	EmployeeID nvarchar(10) foreign key references Employee(EmployeeID) on update cascade on delete set null,
	InsuranceTypeID int foreign key references InsuranceType(InsuranceTypeID) on update cascade on delete set null,
	[Status] bit default 1
)

create table Hospital
(
	HospitalID int primary key,
	HospitalName nvarchar(50) unique not null,
	HospitalAddress nvarchar(50) unique not null,
	[Status] bit default 1
)

create table Officer
(
	OfficerUsername nvarchar(50) primary key,
	OfficerPassword nvarchar(50) not null,
	[Status] bit default 1
)

create table Claim
(
	ClaimID int primary key,
	AccountID int foreign key references Account(AccountID) on update cascade on delete set null,
	InsuranceID int foreign key references Insurance(InsuranceID),
	ClaimAmount float not null,
	ClaimDate date default getDate(),
	ClaimReason nvarchar(400) not null,
	ClaimAttachment nvarchar(250) not null,
	ClaimHospitalID int foreign key references Hospital(HospitalID) on update cascade on delete set null,
	ClaimOfficerUsername  nvarchar(50) foreign key references Officer(OfficerUsername) on update cascade on delete set null,
	ClaimStatus nvarchar(10) default 'In Process',
	[Status] bit default 1
)

create table FAQ
(
	FAQID int primary key,
	FAQQuestion nvarchar(400) unique not null,
	FAQAnswer nvarchar(4000) not null,
	FAQCreatedDate date default getDate(),
	[Status] bit default 1
)

create table [Admin]
(
	AdminUsername nvarchar(50) primary key,
	AdminPassword nvarchar(50) not null
)

insert into [Admin] values('admin','admin')

select * from [Admin]
