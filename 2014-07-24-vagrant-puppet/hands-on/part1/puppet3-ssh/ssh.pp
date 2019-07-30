#
# ssh.pp
#

  package { 'openssh-server':
    ensure => absent,
  }

  file { '/etc/ssh/sshd_config':
    source  => '/vagrant/puppet3-ssh/sshd_config',
    owner   => 'root',
    group   => 'root',
    mode    => '0640',
    notify  => Service['ssh'], # sshd will restart whenever you edit this file.
    require => Package['openssh-server'],
  }

  service { 'ssh':
    ensure     => stopped,
    enable     => false,
    hasstatus  => true,
    hasrestart => true,
  }
