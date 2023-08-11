create index IX_A1221E43 on Contact_Contact (groupId);
create index IX_2CF0947B on Contact_Contact (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BCF9FDBD on Contact_Contact (uuid_[$COLUMN_LENGTH:75$], groupId);