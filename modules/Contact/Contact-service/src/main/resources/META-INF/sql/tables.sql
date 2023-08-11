create table Contact_Contact (
	uuid_ VARCHAR(75) null,
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	telephone VARCHAR(75) null,
	email VARCHAR(75) null
);