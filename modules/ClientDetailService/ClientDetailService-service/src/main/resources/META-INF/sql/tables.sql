create table ClientDetail_ClientDetail (
	uuid_ VARCHAR(75) null,
	clientId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	confirmEmail VARCHAR(75) null,
	age VARCHAR(75) null,
	phoneNo VARCHAR(75) null,
	aadharCard VARCHAR(75) null
);