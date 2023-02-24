---
title: Authorization
parent: Concepts
weight: 52
---

Authorization is handled separately for _Direct Device Integration (DDI) API_ and _Device Management Federation (DMF) API_ (where successful authentication includes full authorization) and _Management API_ and _UI_.
<!--more-->

The default implementation is single user/tenant with basic auth and the logged in user is provided with all permissions. Additionally, the application properties may be configured for multiple static users.

## DDI API

An authenticated target is permitted to:

- retrieve commands from the server
- provide feedback to the the server
- download artifacts that are assigned to it

A target might be permitted to download artifacts without authentication (if enabled, see above). Only the download can be permitted to disable the authentication. This can be used in scenarios where the artifacts itself are e.g. signed and secured.  

## Management API and UI

### OpenID Connect

Bitdove supports authentication providers which use the OpenID Connect standard, an authentication layer built on top of the OAuth 2.0 protocol.

### Delivered Permissions

- READ_/UPDATE_/CREATE_/DELETE_TARGETS for:
  - Target entities including metadata (that includes also the installed and assigned distribution sets)
  - Target tags
  - Target actions
  - Target registration rules
  - Bulk operations
  - Target filters

- READ_/UPDATE_/CREATE_/DELETE_REPOSITORY for:
  - Distribution sets
  - Software Modules
  - Artifacts
  - DS tags

- READ_TARGET_SECURITY_TOKEN
  - Permission to read the target security token. The security token is security concerned and should be protected.

- DOWNLOAD_REPOSITORY_ARTIFACT
  - Permission to download artifacts of a software module (Note: READ_REPOSITORY allows only to read the metadata).

- TENANT_CONFIGURATION
  - Permission to administrate the tenant settings.

- READ_/UPDATE_/CREATE_/DELETE_/HANDLE_/APPROVE_ROLLOUT for:
  - Managing rollouts and provision targets through a rollout.

### Permission Matrix for example uses cases that need more than one permission

