/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.adminavatar.web;

import fr.paris.lutece.plugins.adminavatar.service.AdminAvatarService;
import fr.paris.lutece.portal.service.util.AppPathService;
import fr.paris.lutece.portal.util.mvc.admin.MVCAdminJspBean;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * ManageAdminAvatar JSP Bean abstract class for JSP Bean
 */
public class AdminAvatarJspBean extends MVCAdminJspBean
{
    // Right
    public static final String RIGHT_MANAGEADMINAVATAR = "ADMINAVATAR_MANAGEMENT";
    private static final String TEMPLATE_MANAGE_SQLPAGES = "admin/plugins/adminavatar/adminavatar.html";
    private static final String PROPERTY_PAGE_TITLE_ADMIN_AVATAR = "adminavatar.pageTitle.adminAvatar";
    private static final String VIEW_ADMIN_AVATAR = "home";
    private static final String MARK_AVATAR_SERVER_URL = "server_url";
    private static final String MARK_EMAIL = "email";
    private static final String MARK_ID_USER = "id_user";
    private static final String MARK_RETURN_URL = "return_url";
    private static final String URL_RETURN = "jsp/admin/plugins/adminavatar/ManageAdminAvatar.jsp";

    /**
     * Gets the Avatar
     * @param request The HTTP request
     * @return The avatar URL
     */
    @View( value = VIEW_ADMIN_AVATAR, defaultView = true )
    public String getAdminAvatar( HttpServletRequest request )
    {
        AdminAvatarService.checkAvatarServerConfiguration( request );

        String strAvatarServerUrl = AdminAvatarService.getAvatarServerUrl( request );
        String strEmail = getUser(  ).getEmail(  );
        String strReturnUrl = AppPathService.getBaseUrl( request ) + URL_RETURN;

        Map<String, Object> model = getModel(  );
        model.put( MARK_AVATAR_SERVER_URL, strAvatarServerUrl );
        model.put( MARK_EMAIL, strEmail );
        model.put( MARK_ID_USER, getUser(  ).getUserId(  ) );
        model.put( MARK_RETURN_URL, strReturnUrl );

        return getPage( PROPERTY_PAGE_TITLE_ADMIN_AVATAR, TEMPLATE_MANAGE_SQLPAGES, model );
    }
}
