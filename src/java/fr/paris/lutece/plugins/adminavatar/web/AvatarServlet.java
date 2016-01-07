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
import fr.paris.lutece.plugins.avatar.service.AvatarService;
import fr.paris.lutece.portal.business.user.AdminUser;
import fr.paris.lutece.portal.business.user.AdminUserHome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * AvatarServlet
 */
public class AvatarServlet extends HttpServlet
{
    private static final String PARAMATER_ID_USER = "id_user";
    private static final String URL_DEFAULT_AVATAR = "images/local/skin/plugins/avatarserver/avatar.jpg";

    @Override
    protected void service( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException
    {
        String strUserId = request.getParameter( PARAMATER_ID_USER );
        String strServerUrl = AdminAvatarService.getAvatarServerUrl( request );

        try
        {
            int nIdUser = Integer.parseInt( strUserId );
            AdminUser user = AdminUserHome.findByPrimaryKey( nIdUser );

            if ( user != null )
            {
                String strUrl = strServerUrl + AvatarService.getAvatarUrl( user.getEmail(  ) );
                response.sendRedirect( strUrl );
            }
            else
            {
                response.sendRedirect( strServerUrl + URL_DEFAULT_AVATAR );
            }
        }
        catch ( NumberFormatException e )
        {
            response.sendRedirect( strServerUrl + URL_DEFAULT_AVATAR );
        }
    }
}
