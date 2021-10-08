package com.challenge.magalu.data.model

data class RepositoryPullsResponse(
    val _links: Links?,
    val active_lock_reason: Any?,
    val assignee: Any?,
    val assignees: List<Any?>,
    val author_association: String?,
    val auto_merge: Any?,
    val base: Base?,
    val body: String?,
    val closed_at: Any?,
    val comments_url: String?,
    val commits_url: String?,
    val created_at: String?,
    val diff_url: String?,
    val draft: Boolean?,
    val head: Head?,
    val html_url: String?,
    val id: Int?,
    val issue_url: String?,
    val labels: List<Any?>,
    val locked: Boolean?,
    val merge_commit_sha: String?,
    val merged_at: Any?,
    val milestone: Any?,
    val node_id: String?,
    val number: Int?,
    val patch_url: String?,
    val requested_reviewers: List<Any?>,
    val requested_teams: List<Any?>,
    val review_comment_url: String?,
    val review_comments_url: String?,
    val state: String?,
    val statuses_url: String?,
    val title: String?,
    val updated_at: String?,
    val url: String?,
    val user: User?
) {

    data class Links(
        val comments: Comments?,
        val commits: Commits?,
        val html: Html?,
        val issue: Issue?,
        val review_comment: ReviewComment?,
        val review_comments: ReviewComments?,
        val self: Self?,
        val statuses: Statuses?
    ) {

        data class Comments(
            val href: String?
        )

        data class Commits(
            val href: String?
        )

        data class Html(
            val href: String?
        )

        data class Issue(
            val href: String?
        )

        data class ReviewComment(
            val href: String?
        )

        data class ReviewComments(
            val href: String?
        )

        data class Self(
            val href: String?
        )

        data class Statuses(
            val href: String?
        )
    }

    data class Base(
        val label: String?,
        val ref: String?,
        val repo: Repo?,
        val sha: String?,
        val user: User?
    ) {

        data class Repo(
            val allow_forking: Boolean?,
            val archive_url: String?,
            val archived: Boolean?,
            val assignees_url: String?,
            val blobs_url: String?,
            val branches_url: String?,
            val clone_url: String?,
            val collaborators_url: String?,
            val comments_url: String?,
            val commits_url: String?,
            val compare_url: String?,
            val contents_url: String?,
            val contributors_url: String?,
            val created_at: String?,
            val default_branch: String?,
            val deployments_url: String?,
            val description: String?,
            val disabled: Boolean?,
            val downloads_url: String?,
            val events_url: String?,
            val fork: Boolean?,
            val forks: Int?,
            val forks_count: Int?,
            val forks_url: String?,
            val full_name: String?,
            val git_commits_url: String?,
            val git_refs_url: String?,
            val git_tags_url: String?,
            val git_url: String?,
            val has_downloads: Boolean?,
            val has_issues: Boolean?,
            val has_pages: Boolean?,
            val has_projects: Boolean?,
            val has_wiki: Boolean?,
            val homepage: String?,
            val hooks_url: String?,
            val html_url: String?,
            val id: Int?,
            val is_template: Boolean?,
            val issue_comment_url: String?,
            val issue_events_url: String?,
            val issues_url: String?,
            val keys_url: String?,
            val labels_url: String?,
            val language: String?,
            val languages_url: String?,
            val license: Any?,
            val merges_url: String?,
            val milestones_url: String?,
            val mirror_url: Any?,
            val name: String?,
            val node_id: String?,
            val notifications_url: String?,
            val open_issues: Int?,
            val open_issues_count: Int?,
            val owner: Owner?,
            val `private`: Boolean?,
            val pulls_url: String?,
            val pushed_at: String?,
            val releases_url: String?,
            val size: Int?,
            val ssh_url: String?,
            val stargazers_count: Int?,
            val stargazers_url: String?,
            val statuses_url: String?,
            val subscribers_url: String?,
            val subscription_url: String?,
            val svn_url: String?,
            val tags_url: String?,
            val teams_url: String?,
            val topics: List<String?>,
            val trees_url: String?,
            val updated_at: String?,
            val url: String?,
            val visibility: String?,
            val watchers: Int?,
            val watchers_count: Int?
        ) {

            data class Owner(
                val avatar_url: String?,
                val events_url: String?,
                val followers_url: String?,
                val following_url: String?,
                val gists_url: String?,
                val gravatar_id: String?,
                val html_url: String?,
                val id: Int?,
                val login: String?,
                val node_id: String?,
                val organizations_url: String?,
                val received_events_url: String?,
                val repos_url: String?,
                val site_admin: Boolean?,
                val starred_url: String?,
                val subscriptions_url: String?,
                val type: String?,
                val url: String?
            )
        }

        data class User(
            val avatar_url: String?,
            val events_url: String?,
            val followers_url: String?,
            val following_url: String?,
            val gists_url: String?,
            val gravatar_id: String?,
            val html_url: String?,
            val id: Int?,
            val login: String?,
            val node_id: String?,
            val organizations_url: String?,
            val received_events_url: String?,
            val repos_url: String?,
            val site_admin: Boolean?,
            val starred_url: String?,
            val subscriptions_url: String?,
            val type: String?,
            val url: String?
        )
    }

    data class Head(
        val label: String?,
        val ref: String?,
        val repo: Repo?,
        val sha: String?,
        val user: User?
    ) {

        data class Repo(
            val allow_forking: Boolean?,
            val archive_url: String?,
            val archived: Boolean?,
            val assignees_url: String?,
            val blobs_url: String?,
            val branches_url: String?,
            val clone_url: String?,
            val collaborators_url: String?,
            val comments_url: String?,
            val commits_url: String?,
            val compare_url: String?,
            val contents_url: String?,
            val contributors_url: String?,
            val created_at: String?,
            val default_branch: String?,
            val deployments_url: String?,
            val description: String?,
            val disabled: Boolean?,
            val downloads_url: String?,
            val events_url: String?,
            val fork: Boolean?,
            val forks: Int?,
            val forks_count: Int?,
            val forks_url: String?,
            val full_name: String?,
            val git_commits_url: String?,
            val git_refs_url: String?,
            val git_tags_url: String?,
            val git_url: String?,
            val has_downloads: Boolean?,
            val has_issues: Boolean?,
            val has_pages: Boolean?,
            val has_projects: Boolean?,
            val has_wiki: Boolean?,
            val homepage: String?,
            val hooks_url: String?,
            val html_url: String?,
            val id: Int?,
            val is_template: Boolean?,
            val issue_comment_url: String?,
            val issue_events_url: String?,
            val issues_url: String?,
            val keys_url: String?,
            val labels_url: String?,
            val language: Any,
            val languages_url: String,
            val license: Any?,
            val merges_url: String?,
            val milestones_url: String?,
            val mirror_url: Any?,
            val name: String?,
            val node_id: String?,
            val notifications_url: String?,
            val open_issues: Int?,
            val open_issues_count: Int?,
            val owner: Owner?,
            val `private`: Boolean?,
            val pulls_url: String?,
            val pushed_at: String?,
            val releases_url: String?,
            val size: Int?,
            val ssh_url: String?,
            val stargazers_count: Int?,
            val stargazers_url: String?,
            val statuses_url: String?,
            val subscribers_url: String?,
            val subscription_url: String?,
            val svn_url: String?,
            val tags_url: String?,
            val teams_url: String?,
            val topics: List<Any?>,
            val trees_url: String?,
            val updated_at: String?,
            val url: String?,
            val visibility: String?,
            val watchers: Int?,
            val watchers_count: Int?
        ) {

            data class Owner(
                val avatar_url: String?,
                val events_url: String?,
                val followers_url: String?,
                val following_url: String?,
                val gists_url: String?,
                val gravatar_id: String?,
                val html_url: String?,
                val id: Int?,
                val login: String?,
                val node_id: String?,
                val organizations_url: String?,
                val received_events_url: String?,
                val repos_url: String?,
                val site_admin: Boolean?,
                val starred_url: String?,
                val subscriptions_url: String?,
                val type: String?,
                val url: String?
            )
        }

        data class User(
            val avatar_url: String?,
            val events_url: String?,
            val followers_url: String?,
            val following_url: String?,
            val gists_url: String?,
            val gravatar_id: String?,
            val html_url: String?,
            val id: Int?,
            val login: String?,
            val node_id: String?,
            val organizations_url: String?,
            val received_events_url: String?,
            val repos_url: String?,
            val site_admin: Boolean?,
            val starred_url: String?,
            val subscriptions_url: String?,
            val type: String?,
            val url: String?
        )
    }

    data class User(
        val avatar_url: String?,
        val events_url: String?,
        val followers_url: String?,
        val following_url: String?,
        val gists_url: String?,
        val gravatar_id: String?,
        val html_url: String?,
        val id: Int?,
        val login: String?,
        val node_id: String?,
        val organizations_url: String?,
        val received_events_url: String?,
        val repos_url: String?,
        val site_admin: Boolean?,
        val starred_url: String?,
        val subscriptions_url: String?,
        val type: String?,
        val url: String?
    )
}