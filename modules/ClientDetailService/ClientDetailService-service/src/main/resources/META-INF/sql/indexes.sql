create index IX_2D5ED59E on ClientDetail_ClientDetail (aadharCard[$COLUMN_LENGTH:75$]);
create index IX_A08DCB2A on ClientDetail_ClientDetail (age[$COLUMN_LENGTH:75$]);
create index IX_1E86A255 on ClientDetail_ClientDetail (confirmEmail[$COLUMN_LENGTH:75$]);
create index IX_92032047 on ClientDetail_ClientDetail (email[$COLUMN_LENGTH:75$]);
create index IX_870A8F64 on ClientDetail_ClientDetail (name[$COLUMN_LENGTH:75$]);
create index IX_62157D7A on ClientDetail_ClientDetail (phoneNo[$COLUMN_LENGTH:75$]);
create index IX_F3F77219 on ClientDetail_ClientDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7CB7AADB on ClientDetail_ClientDetail (uuid_[$COLUMN_LENGTH:75$], groupId);