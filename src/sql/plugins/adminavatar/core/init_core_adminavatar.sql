
--
-- Data for table core_admin_right
--
DELETE FROM core_admin_right WHERE id_right = 'ADMINAVATAR_MANAGEMENT';
INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url, id_order ) VALUES 
('ADMINAVATAR_MANAGEMENT','adminavatar.adminFeature.ManageAdminAvatar.name',1,'jsp/admin/plugins/adminavatar/ManageAdminAvatar.jsp','adminavatar.adminFeature.ManageAdminAvatar.description',0,'adminavatar',NULL,NULL,NULL,4);


--
-- Data for table core_user_right
--
DELETE FROM core_user_right WHERE id_right = 'ADMINAVATAR_MANAGEMENT';
INSERT INTO core_user_right (id_right,id_user) VALUES ('ADMINAVATAR_MANAGEMENT',1);

--
-- Data for table core_datastore
--
DELETE FROM core_datastore WHERE entity_key = 'adminavatar.site_property.avatarserver.Url';
INSERT INTO core_datastore (entity_key, entity_value) VALUES ('adminavatar.site_property.avatarserver.Url', '');

