package com.example.bookshelf.domain.app;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "app", name = "oauth_client_details")
@Data
public class OauthUserDetails {

    @Id
    @Column(name = "client_id")
    private String clientId;

    @NotNull
    @Column(name = "client_secret")
    private String clientSecret;

    @NotNull
    @Column(name = "resource_ids")
    private String resourceIds;

    private String scope;

    @NotNull
    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;

    @NotNull
    private String authorities;

    @Min(1)
    @NotNull
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    @Min(1)
    @NotNull
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @Column(name = "additional_information")
    private String additionalInformation;

    private String autoapprove;
}
